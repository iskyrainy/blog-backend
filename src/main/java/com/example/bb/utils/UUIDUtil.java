package com.example.bb.utils;

import java.util.UUID;

/**
 * <p>className: com.example.bb.utils-UUIDUtil
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public class UUIDUtil {
    public static UUID randomUUID() {
        return UUID.randomUUID();
    }

    public static String randomUUIDStr() {
        return randomUUID().toString();
    }

    public static String randomUUIDStrWithoutDash() {
        return randomUUIDStr().replace("-", "");
    }
}
