package com.example.bb.handler;

import com.alibaba.fastjson2.JSONObject;
import com.example.bb.exception.BlogAuthException;
import com.example.bb.exception.BlogException;
import com.example.bb.utils.ResultVOUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>className: com.example.bb.handler-BlogExceptionHandler
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@ControllerAdvice
public class BlogExceptionHandler {
    @ExceptionHandler(BlogAuthException.class)
    public HttpServletResponse handlerAuthorizeException() throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletResponse response = attributes.getResponse();
            if (response != null) {
                response.setContentType("application/json;charset=utf-8");
                JSONObject json = JSONObject.from(ResultVOUtil.error("login expired!", null));
                PrintWriter writer = response.getWriter();
                writer.write(json.toJSONString());
                writer.close();
                return response;
            }
        }
        return null;
    }
}
