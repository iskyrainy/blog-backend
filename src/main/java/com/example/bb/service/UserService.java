package com.example.bb.service;

import com.example.bb.dataobject.User;

/**
 * <p>className: com.example.bb.service-UserService
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public interface UserService {
    String login(User user);

    String register(User user);
}
