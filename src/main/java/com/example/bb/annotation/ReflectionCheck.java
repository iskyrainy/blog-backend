package com.example.bb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>className: com.example.bb.annotation-ReflectionCheck
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/21
 **/
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReflectionCheck {
    int index();
}
