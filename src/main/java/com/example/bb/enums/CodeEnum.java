package com.example.bb.enums;

import lombok.Getter;

/**
 * <p>className: com.example.bb.enums-CodeEnum
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@Getter
public enum CodeEnum {
    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    TOKEN_NOT_FOUND(2, "token信息丢失"),
    TOKEN_EXPIRED(3, "token已过期"),
    ;

    private final int code;
    private final String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
