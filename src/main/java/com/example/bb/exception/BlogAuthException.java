package com.example.bb.exception;

import com.example.bb.enums.CodeEnum;

/**
 * <p>className: com.example.bb.exception-BlogAuthException
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public class BlogAuthException extends BlogException{
    public BlogAuthException(CodeEnum codeEnum) {
        super(codeEnum);
    }

    public BlogAuthException(int code, String msg) {
        super(code, msg);
    }
}
