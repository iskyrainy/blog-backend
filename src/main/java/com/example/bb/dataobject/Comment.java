package com.example.bb.dataobject;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * <p>className: com.example.bb.dataobject-Comment
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@Entity
@Table(name = "comment")
@Data
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", columnDefinition = "varchar(20) not null")
    private String id;

    @Column(name = "host_id", columnDefinition = "varchar(20) not null")
    private String hostId;

    @Column(name = "blog_id", columnDefinition = "varchar(20) not null")
    private String blogId;

    @Column(name = "content", columnDefinition = "varchar(255)")
    private String content;

    @CreatedDate
    @Column(name = "create_date", nullable = false)
    private Date createDate;
}
