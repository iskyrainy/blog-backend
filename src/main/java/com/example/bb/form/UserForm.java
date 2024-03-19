package com.example.bb.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * <p>className: com.example.bb.form-UserForm
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@Data
public class UserForm {
    @NotEmpty(message = "username is not null")
    private String username;
    private String password;
    private String phone;
    private int typeId;
}
