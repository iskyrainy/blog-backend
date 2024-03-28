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
 * <p>className: com.example.bb.dataobject-Blog
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@Entity
@Table(name = "blog")
@Data
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class Blog {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", columnDefinition = "varchar(20) not null")
    private String id;

    @Column(name = "title", columnDefinition = "varchar(255) not null")
    private String title;

    @Column(name = "host_id", columnDefinition = "varchar(20) not null")
    private String hostId;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @CreatedDate
    @Column(name = "create_date", updatable = false, nullable = false)
    private Date createDate;

    @LastModifiedDate
    @Column(name = "update_date", nullable = false)
    private Date updateDate;
}
