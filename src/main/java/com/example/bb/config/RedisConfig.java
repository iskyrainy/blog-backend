package com.example.bb.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>className: com.example.bb.config-RedisConfig
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public class RedisConfig {
    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.afterPropertiesSet();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
