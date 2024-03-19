package com.example.bb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>className: com.example.bb.utils-RedisUtil
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@Component
public class RedisUtil {
    private static RedisTemplate<String, Object> template;

    @Autowired
    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        template = redisTemplate;
    }

    public static RedisTemplate<String, Object> getRedisTemplate() {
        return template;
    }
}
