package com.example.bb.utils;

import com.example.bb.annotation.ReflectionCheck;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>className: com.example.bb.utils-ReflectionCheckUtil
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/21
 **/
@Slf4j
public final class ReflectionCheckUtil {
    private volatile static Class<?> clazz;

    private ReflectionCheckUtil() {}

    @NotNull
    private static void init(Object o) {
        if (clazz == null) {
            synchronized (ReflectionCheckUtil.class) {
                if (clazz == null) {
                    clazz = o.getClass();
                }
            }
        } else if (clazz != o.getClass()) {
            synchronized (ReflectionCheckUtil.class) {
                if (clazz != o.getClass()) {
                    clazz = o.getClass();
                }
            }
        }
    }

    @NotNull
    public static Class<?> getClazz(Object o) {
        init(o);
        return clazz;
    }

    public static boolean paramCheck(@NotNull Object o, int... ints) {
        init(o);
        Set<Integer> set = new HashSet<>();
        for (int i : ints)
            set.add(i);
        return paramCheck(o ,set);
    }

    public static boolean paramCheck(@NotNull Object o, Set<Integer> set) {
        init(o);
        try {
            for (Field field : clazz.getFields()) {
                field.setAccessible(true);
                if (set.contains(field.getAnnotation(ReflectionCheck.class).index())) {
                    if (field.get(o) == null)
                        return false;
                }
            }
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }
}
