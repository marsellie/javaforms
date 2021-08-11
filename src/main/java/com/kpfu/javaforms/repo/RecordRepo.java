package com.kpfu.javaforms.repo;

import com.kpfu.javaforms.entity.Record;
import com.kpfu.javaforms.repo.base.BaseLongRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends BaseLongRepo<Record> {
}
