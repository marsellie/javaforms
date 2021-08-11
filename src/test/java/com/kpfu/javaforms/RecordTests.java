package com.kpfu.javaforms;

import com.kpfu.javaforms.entity.AppUser;
import com.kpfu.javaforms.entity.Record;
import com.kpfu.javaforms.exceptions.RestException;
import com.kpfu.javaforms.service.AppUserCrudService;
import com.kpfu.javaforms.service.RecordCrudService;
import com.kpfu.javaforms.util.RandomUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecordTests {
    @Autowired
    private AppUserCrudService userService;
    @Autowired
    private RecordCrudService service;

    private static Record record;

    @Test
    @Order(-1)
    void _createRecordTest() throws RestException {
        var user = userService.get(PageRequest.of(0, 1)).get(0);
        new ArrayList<Record>(){{
            add(new Record(null, null));
            add(new Record(null, ""));
            add(new Record(null, " "));
        }}.forEach(badRecord -> Assertions.assertThrows(ConstraintViolationException.class, () -> {
            try {
                var created = service.save(badRecord, user.getId());
                int i = 0;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }));
    }
}
