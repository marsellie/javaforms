package com.kpfu.javaforms.util;

import java.util.Random;

public class RandomUtil {
    public static Random random = new Random();

    public static String randomString(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
