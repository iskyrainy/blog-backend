package com.example.bb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>className: com.example.bb.utils-RedisUtil
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public class RedisUtil {
    private volatile static RedisTemplate<String, Object> template;

    private RedisUtil() {}

    /**
     * @description: get template instance
     * @author: wn
     * @date: 2024/3/19
     * @param: []:[]
     * @return: org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.lang.Object>
     **/
    public static RedisTemplate<String, Object> getTemplate() {
        if (template == null) {
            synchronized (RedisUtil.class) {
                if (template == null) {
                    template = ContextUtil.getContext().getBean(RedisTemplate.class);
                }
            }
        }
        return template;
    }
}
