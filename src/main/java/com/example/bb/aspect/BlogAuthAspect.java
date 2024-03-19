package com.example.bb.aspect;

import com.example.bb.constant.TokenConstant;
import com.example.bb.enums.CodeEnum;
import com.example.bb.exception.BlogAuthException;
import com.example.bb.exception.BlogException;
import com.example.bb.utils.CookieUtil;
import com.example.bb.utils.RedisUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <p>className: com.example.bb.aspect-BlogAuthAspect
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
//@Aspect
//@Component
@Slf4j
public class BlogAuthAspect {
    @Pointcut(value = "execution(public * com.example.bb.controller.UserController.*(..))")
    public void verify() {}

    @Before(value = "verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            Cookie cookie = CookieUtil.get(request, TokenConstant.TOKEN);
            if (cookie == null) {
                log.warn("can not get token info!");
                throw new BlogAuthException(CodeEnum.TOKEN_NOT_FOUND);
            } else {
                RedisTemplate<String, Object> template = RedisUtil.getTemplate();
                Boolean exist = template.hasKey(cookie.getValue());
                if (exist == null || !exist) {
                    log.warn("login expired!");
                    throw new BlogAuthException(CodeEnum.TOKEN_EXPIRED);
                }
            }
        }
    }
}
