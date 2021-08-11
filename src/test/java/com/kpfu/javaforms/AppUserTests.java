package com.kpfu.javaforms;

import com.kpfu.javaforms.entity.AppUser;
import com.kpfu.javaforms.exceptions.RestException;
import com.kpfu.javaforms.service.AppUserCrudService;
import com.kpfu.javaforms.util.RandomUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppUserTests {
    @Autowired
    private AppUserCrudService service;

    private static AppUser user;

    @Test
    @Order(0)
    void createUserTest() {
        user = new AppUser();
        user.setAuthorities(Collections.singleton(AppUser.Roles.USER));

        user.setUsername(RandomUtil.randomString(10));
        user.setNickname(RandomUtil.randomString(10));
        user.setPassword(RandomUtil.randomString(10));

        Assertions.assertDoesNotThrow(() -> {
            user = service.save(user);
        });
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());
    }

    @Test
    @Order(1)
    void readUserTest() throws RestException {
        var fromDb = service.get(user.getId());
        Assertions.assertEquals(user.getId(), fromDb.getId());
        Assertions.assertEquals(user.getUsername(), fromDb.getUsername());
        Assertions.assertEquals(user.getPassword(), fromDb.getPassword());
        Assertions.assertEquals(user.getNickname(), fromDb.getNickname());
    }

    @Test
    @Order(2)
    void updateUserTest() {
        var newUser = new AppUser();
        newUser.setId(user.getId());

        newUser.setPassword(RandomUtil.randomString(10));
        newUser.setUsername(RandomUtil.randomString(10));
        newUser.setNickname(RandomUtil.randomString(10));

        user = service.update(newUser);
        Assertions.assertEquals(newUser.getId(), user.getId());
        Assertions.assertEquals(newUser.getPassword(), user.getPassword());
        Assertions.assertEquals(newUser.getUsername(), user.getUsername());
        Assertions.assertEquals(newUser.getNickname(), user.getNickname());
    }

    @Test
    @Order(3)
    void deleteUserTest(){
        var id = service.delete(user);
        Assertions.assertEquals(id, user.getId());
        Assertions.assertThrows(RestException.class, () -> service.get(user.getId()));
    }
}
