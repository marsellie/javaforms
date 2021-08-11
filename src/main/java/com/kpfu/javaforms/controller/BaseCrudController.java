package com.kpfu.javaforms.controller;

import com.kpfu.javaforms.entity.base.BaseEntity;
import com.kpfu.javaforms.service.base.BaseCrudService;
import com.kpfu.javaforms.util.RestResponse;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseCrudController<TID extends Comparable<TID>, T extends BaseEntity<TID>, TService extends BaseCrudService<?, T, ?>> {
    protected TService service;

    public RestResponse create(@RequestBody T t) {
        return RestResponse.okResponse(service.save(t));
    }

}
