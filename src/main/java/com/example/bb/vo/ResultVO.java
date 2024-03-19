package com.example.bb.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>className: com.example.bb.vo-ResultVO
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@Data
@Accessors(chain = true)
public class ResultVO<T> {
    private int code;
    private String msg;
    private T data;
}
