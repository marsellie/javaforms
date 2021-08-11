package com.kpfu.javaforms.service;

import com.kpfu.javaforms.entity.AppUser;
import com.kpfu.javaforms.entity.Record;
import com.kpfu.javaforms.repo.RecordRepo;
import com.kpfu.javaforms.service.base.BaseChildCrudService;
import org.springframework.stereotype.Service;


@Service
public class RecordCrudService extends BaseChildCrudService<Long, Record, RecordRepo, Long, AppUser, AppUserCrudService> {
    public RecordCrudService(RecordRepo repo, AppUserCrudService parentService) {
        super(repo, parentService, Record::setUser);
    }
}
