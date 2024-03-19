package com.example.bb.exception;

import com.example.bb.enums.CodeEnum;

/**
 * <p>className: com.example.bb.exception-BlogException
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public class BlogException extends RuntimeException{
    private final int code;

    public BlogException(CodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
    }

    public BlogException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
