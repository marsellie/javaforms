package com.kpfu.javaforms;

import com.kpfu.javaforms.util.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RandomUtilTest {
    @Test
    void testRandomString() {
        new ArrayList<Integer>() {{
            add(10);
            add(20);
            add(30);
        }}.forEach(expectedLength -> {
            var randomString = RandomUtil.randomString(expectedLength);
            var actualLength = randomString.length();
            Assertions.assertEquals(expectedLength, actualLength);
        });
    }
}
