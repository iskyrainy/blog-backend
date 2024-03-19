package com.example.bb.handler;

import com.alibaba.fastjson2.JSONObject;
import com.example.bb.exception.BlogAuthException;
import com.example.bb.utils.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <p>className: com.example.bb.handler-BlogExceptionHandler
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@ControllerAdvice
public class BlogExceptionHandler {
    @ExceptionHandler(BlogAuthException.class)
    public ResponseEntity<String> handlerAuthorizeException(BlogAuthException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(JSONObject.toJSONString(ResultVOUtil.error(ex.getMessage(), null)));
    }
}
