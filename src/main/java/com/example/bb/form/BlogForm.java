package com.example.bb.form;

import com.example.bb.annotation.ReflectionCheck;
import lombok.Data;

/**
 * <p>className: com.example.bb.form-BlogForm
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/21
 **/
@Data
public class BlogForm {
    @ReflectionCheck(index = 1)
    private String id;
    @ReflectionCheck(index = 2)
    private String title;
    @ReflectionCheck(index = 3)
    private String hostId;
    @ReflectionCheck(index = 4)
    private String content;
}
