package com.kpfu.javaforms.repo.base;

import com.kpfu.javaforms.entity.base.LongEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseLongRepo<T extends LongEntity> extends BaseRepo<Long, T> {
}
