package com.example.bb.form;

import com.example.bb.annotation.ReflectionCheck;
import lombok.Data;

/**
 * <p>className: com.example.bb.form-UserForm
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@Data
public class UserForm {
    @ReflectionCheck(index = 1)
    private String username;
    @ReflectionCheck(index = 2)
    private String password;
    @ReflectionCheck(index = 3)
    private String phone;
    @ReflectionCheck(index = 4)
    private int typeId;
}
