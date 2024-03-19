package com.example.bb.utils;

import com.example.bb.vo.ResultVO;

/**
 * <p>className: com.example.bb.utils-ResultVOUtil
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public class ResultVOUtil {
    public static <T> ResultVO<T> success() {
        return success(null);
    }

    public static <T> ResultVO<T> success(T data) {
        return success("action success", data);
    }

    public static <T> ResultVO<T> success(String msg, T data) {
        return new ResultVO<T>()
                .setCode(200)
                .setMsg(msg)
                .setData(data);
    }

    public static <T> ResultVO<T> error() {
        return error("action error", null);
    }

    public static <T> ResultVO<T> error(String err, T data) {
        return error(500, err, data);
    }

    public static <T> ResultVO<T> error(int code, String err, T data) {
        return new ResultVO<T>()
                .setCode(code)
                .setMsg(err)
                .setData(data);
    }
}
