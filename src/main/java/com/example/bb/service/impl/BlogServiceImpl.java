package com.example.bb.service.impl;

import com.example.bb.dataobject.Blog;
import com.example.bb.repository.BlogRepository;
import com.example.bb.service.BlogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>className: com.example.bb.service.impl-BlogServiceImpl
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/20
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    BlogRepository blogRepository;

    @Override
    public Blog create(Blog blog) {
        return null;
    }

    @Override
    public boolean update(Blog blog) {
        return false;
    }

    @Override
    public boolean delete(Blog blog) {
        return false;
    }

    @Override
    public List<Blog> list(String hostId) {
        return null;
    }

    @Override
    public Blog open(Blog blog) {
        return null;
    }
}
