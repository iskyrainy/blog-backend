package com.example.bb.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>className: com.example.bb.vo-UserVO
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/24
 **/
@Data
@Accessors(chain = true)
public class UserVO {
    private String id;
    private String username;
    private String token;
}
