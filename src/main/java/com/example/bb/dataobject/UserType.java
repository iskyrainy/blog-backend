package com.example.bb.dataobject;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * <p>className: com.example.bb.dataobject-UserType
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/4
 **/
@Entity
@Table(name = "user_type")
@Data
@DynamicUpdate
@DynamicInsert
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "write_blog")
    private int writeBlog;

    @Column(name = "update_blog")
    private int updateBlog;

    @Column(name = "delete_my_blog")
    private int deleteMyBlog;

    @Column(name = "delete_other_blog")
    private int deleteOtherBlog;

    @Column(name = "comment_blog")
    private int commentBlog;
}
