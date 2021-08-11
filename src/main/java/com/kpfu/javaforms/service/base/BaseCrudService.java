package com.kpfu.javaforms.service.base;

import com.kpfu.javaforms.entity.base.BaseEntity;
import com.kpfu.javaforms.exceptions.ExceptionMessages;
import com.kpfu.javaforms.exceptions.RestException;
import com.kpfu.javaforms.repo.base.BaseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseCrudService<
        TID extends Comparable<TID>,
        T extends BaseEntity<TID>,
        TRepo extends BaseRepo<TID, T>
        > {
    protected final TRepo repo;

    private static final HashMap<Class<?>, String[]> ignoreProperties = new HashMap<>();

    private String[] getPropertiesToIgnore(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        ArrayList<String> properties = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(ManyToOne.class) ||
                    field.isAnnotationPresent(ManyToMany.class) ||
                    field.isAnnotationPresent(OneToMany.class) ||
                    field.isAnnotationPresent(OneToOne.class))
                properties.add(field.getName());
        }

        return properties.toArray(String[]::new);
    }

    public List<T> get(Pageable pageable) {
        return repo.findAll(pageable).getContent();
    }

    public T get(TID id) throws RestException {
        return repo.findById(id).orElseThrow(() -> new RestException(ExceptionMessages.NOT_FOUND_BY_ID.formatted(id.toString())));
    }

    public T save(T t) {
        return repo.saveAndFlush(t);
    }

    public T update(T newT) {
        T t = repo.getById(newT.getId());
        String[] ignore = ignoreProperties.computeIfAbsent(t.getClass(), this::getPropertiesToIgnore);
        BeanUtils.copyProperties(newT, t, ignore);
        return save(t);
    }

    public TID delete(T t) {
        repo.delete(t);
        return t.getId();
    }
}
