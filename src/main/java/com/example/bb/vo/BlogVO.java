package com.example.bb.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>className: com.example.bb.vo-BlogVO
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/24
 **/
@Data
@Accessors(chain = true)
public class BlogVO {
    private String id;
    private String title;
    private String host;
    private String content;
    private Date createDate;
    private Date updateDate;
}
