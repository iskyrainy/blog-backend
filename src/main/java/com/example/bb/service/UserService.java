package com.example.bb.service;

import com.example.bb.dataobject.User;
import jakarta.servlet.http.Cookie;

/**
 * <p>className: com.example.bb.service-UserService
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public interface UserService {
    String login(User user);

    String register(User user);

    String logout(Cookie cookie);
}
