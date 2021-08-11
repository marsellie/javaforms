/*
package com.kpfu.javaforms.service;

import com.kpfu.javaforms.entity.base.BaseEntity;
import com.kpfu.javaforms.exceptions.ExceptionMessages;
import com.kpfu.javaforms.exceptions.RestException;
import com.kpfu.javaforms.repo.base.BaseRepo;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.function.Function;

public abstract class BaseMultiChildCrudService<
        TID extends Comparable<TID>,
        T extends BaseEntity<TID>,
        TRepo extends BaseRepo<TID, T>,
        TPID extends Comparable<TPID>,
        TP extends BaseEntity<TPID>,
        TPService extends BaseRepo<TPID, TP>
        > extends BaseCrudService<TID, T, TRepo> {
    private final TPService parentService;
    private final Function<TP, Collection<T>> supplier;

    public BaseMultiChildCrudService(TRepo repo, TPService parentService, Function<TP, Collection<T>> supplier) {
        super(repo);
        this.parentService = parentService;
        this.supplier = supplier;
    }


    @Override
    public T create(T t) throws RestException {
        throw new RestException(ExceptionMessages.CANT_CREATE_CHILD_WITHOUT_PARENT);
    }

    public T create(T t, TPID parentId) {
        TP tp = parentService.getById(parentId);
        Collection<T> ts = supplier.apply(tp);
        ts.add(t);
        parentService.save(tp);
        return t;
    }
}
*/
