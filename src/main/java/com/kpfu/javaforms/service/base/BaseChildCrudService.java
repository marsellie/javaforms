package com.kpfu.javaforms.service.base;

import com.kpfu.javaforms.entity.base.BaseEntity;
import com.kpfu.javaforms.exceptions.RestException;
import com.kpfu.javaforms.repo.base.BaseRepo;

import java.util.function.BiConsumer;

public abstract class BaseChildCrudService<
        TID extends Comparable<TID>,
        T extends BaseEntity<TID>,
        TRepo extends BaseRepo<TID, T>,
        TPID extends Comparable<TPID>,
        TP extends BaseEntity<TPID>,
        TPService extends BaseCrudService<TPID, TP, ?>
        > extends BaseCrudService<TID, T, TRepo> {
    private final TPService parentService;
    private final BiConsumer<T, TP> parentSetter;

    public BaseChildCrudService(TRepo repo, TPService parentService, BiConsumer<T, TP> parentSetter) {
        super(repo);
        this.parentService = parentService;
        this.parentSetter = parentSetter;
    }

    public T save(T t, TPID parentId) throws RestException {
        TP tp = parentService.get(parentId);
        parentSetter.accept(t, tp);
        return save(t);
    }
}
