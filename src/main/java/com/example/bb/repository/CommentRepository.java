package com.example.bb.repository;

import com.example.bb.dataobject.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>className: com.example.bb.repository-CommentRepository
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public interface CommentRepository extends JpaRepository<Comment, String> {
}
