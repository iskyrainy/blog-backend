package com.example.bb.repository;

import com.example.bb.dataobject.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>className: com.example.bb.repository-BlogRepository
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public interface BlogRepository extends JpaRepository<Blog, String> {
}
