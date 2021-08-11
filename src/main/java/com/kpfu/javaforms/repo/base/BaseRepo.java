package com.kpfu.javaforms.repo.base;

import com.kpfu.javaforms.entity.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<ID extends Comparable<ID>, T extends BaseEntity<ID>> extends JpaRepository<T, ID> {
}
