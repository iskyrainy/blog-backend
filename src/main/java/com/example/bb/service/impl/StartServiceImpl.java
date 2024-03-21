package com.example.bb.service.impl;

import com.example.bb.repository.UserTypeRepository;
import com.example.bb.service.StartService;
import com.example.bb.utils.RedisUtil;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>className: com.example.bb.service.impl-StartServiceImpl
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/20
 **/
@Service
public class StartServiceImpl implements StartService {

    @Resource
    UserTypeRepository userTypeRepository;

    @Override
    public void initApplication() {
        RedisTemplate<String, Object> template = RedisUtil.getRedisTemplate();
        userTypeRepository.findAll().forEach(o -> template.opsForList().leftPush("AL", o));
    }
}
