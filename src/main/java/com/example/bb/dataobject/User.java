package com.example.bb.dataobject;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * <p>className: com.example.bb.dataobject-User
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/4
 **/
@Entity
@Table(name = "user")
@Data
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "varchar(20) not null")
    private String id;

    @Column(name = "username", columnDefinition = "varchar(20) not null")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(20) not null")
    private String password;

    @Column(name = "phone", columnDefinition = "varchar(20) not null")
    private String phone;

    @Column(name = "type_id")
    private int typeId;

    @Column(name = "locked")
    private int locked;

    @CreatedDate
    @Column(name = "create_date", updatable = false, nullable = false)
    private Date createDate;

    @LastModifiedDate
    @Column(name = "update_date", nullable = false)
    private Date updateDate;
}
