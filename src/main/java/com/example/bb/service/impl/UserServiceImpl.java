package com.example.bb.service.impl;

import com.example.bb.constant.TokenConstant;
import com.example.bb.dataobject.User;
import com.example.bb.repository.UserRepository;
import com.example.bb.service.UserService;
import com.example.bb.utils.ArgonUtil;
import com.example.bb.utils.RedisUtil;
import com.example.bb.utils.UUIDUtil;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>className: com.example.bb.service.impl-UserServiceImpl
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public String login(User user) {
        User r = userRepository.findByUsernameAndLocked(user.getUsername(), 0);
        if (r == null)
            return null;
        if (ArgonUtil.verify(user.getPassword(), r.getPassword())) {
            String token = UUIDUtil.randomUUIDStrWithoutDash();
            RedisTemplate<String, Object> template = RedisUtil.getRedisTemplate();
            template.opsForValue().set(token, r.getId(), TokenConstant.expire, TimeUnit.SECONDS);
            return token;
        }
        return null;
    }

    @Override
    public String register(User user) {
        User r = userRepository.findByUsernameOrPhone(user.getUsername(), user.getPhone());
        if (r == null) {
            user.setLocked(0);
            r = userRepository.save(user);
            return r.getUsername();
        } else
            return null;
    }
}
