package com.kpfu.javaforms.entity.base;

import javax.persistence.*;

@Entity
@Table
public abstract class LongEntity extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long aLong) {
        id = aLong;
    }
}
