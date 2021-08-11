package com.kpfu.javaforms.entity.base;

import javax.persistence.Transient;
import java.rmi.dgc.VMID;

public abstract class BaseEntity<T extends Comparable<T>>
        implements Comparable<BaseEntity<T>> {
    @Transient
    private Integer hashCode;

    public abstract T getId();

    public abstract void setId(T t);

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj == this ||
                (obj.getClass().isAssignableFrom(getClass()) && hashCode() == obj.hashCode()));
    }

    @Override
    public int hashCode() {
        T id = getId();
        if (id != null)
            return id.hashCode();
        if (hashCode != null)
            hashCode = new VMID().hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(BaseEntity<T> o) {
        return o.getId().compareTo(getId());
    }
}
