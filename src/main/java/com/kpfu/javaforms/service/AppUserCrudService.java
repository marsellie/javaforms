package com.kpfu.javaforms.service;

import com.kpfu.javaforms.entity.AppUser;
import com.kpfu.javaforms.repo.AppUserRepo;
import com.kpfu.javaforms.service.base.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class AppUserCrudService extends BaseCrudService<Long, AppUser, AppUserRepo> {
    public AppUserCrudService(AppUserRepo repo) {
        super(repo);
    }
}
