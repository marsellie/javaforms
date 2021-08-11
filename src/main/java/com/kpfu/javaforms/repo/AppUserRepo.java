package com.kpfu.javaforms.repo;

import com.kpfu.javaforms.entity.AppUser;
import com.kpfu.javaforms.repo.base.BaseLongRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends BaseLongRepo<AppUser> {
}
