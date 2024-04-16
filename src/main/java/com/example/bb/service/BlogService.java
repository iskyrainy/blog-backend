package com.example.bb.service;

import com.example.bb.dataobject.Blog;

import java.util.List;

/**
 * <p>className: com.example.bb.service-BlogService
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/20
 **/
public interface BlogService {
    Blog create(Blog blog);

    boolean update(Blog blog);

    boolean delete(Blog blog);

    List<Blog> list(String hostId);

    Blog open(Blog blog);
}
