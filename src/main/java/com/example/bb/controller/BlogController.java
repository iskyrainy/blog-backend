package com.example.bb.controller;

import com.example.bb.dataobject.Blog;
import com.example.bb.form.BlogForm;
import com.example.bb.service.BlogService;
import com.example.bb.utils.ReflectionCheckUtil;
import com.example.bb.utils.ResultVOUtil;
import com.example.bb.vo.BlogVO;
import com.example.bb.vo.ResultVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>className: com.example.bb.controller-BlogController
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/21
 **/
@RestController(value = "/blog")
@CrossOrigin
@Slf4j
public class BlogController {

    @Resource
    BlogService blogService;

    @PostMapping(value = "/create")
    public ResultVO<BlogVO> create(@RequestBody BlogForm blogForm) {
        ReflectionCheckUtil.paramCheck(blogForm, 1, 2, 3);
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogForm, blog);
        BlogVO blogVO = new BlogVO();
        BeanUtils.copyProperties(blogService.create(blog), blogVO);
        return blogVO.getId() == null ? ResultVOUtil.error() : ResultVOUtil.success(blogVO);
    }

    @PostMapping(value = "/update")
    public ResultVO<BlogVO> update(@RequestBody BlogForm blogForm) {
        ReflectionCheckUtil.paramCheck(blogForm, 1);
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogForm, blog);
        return blogService.update(blog) ? ResultVOUtil.success() : ResultVOUtil.error();
    }

    @PostMapping(value = "/delete")
    public ResultVO<BlogVO> delete(@RequestBody BlogForm blogForm) {
        ReflectionCheckUtil.paramCheck(blogForm, 1);
        Blog blog = new Blog();
        blog.setId(blogForm.getId());
        return blogService.delete(blog) ? ResultVOUtil.success() : ResultVOUtil.error();
    }

    @PostMapping(value = "/list")
    public ResultVO<List<BlogVO>> list(@RequestBody BlogForm blogForm) {
        ReflectionCheckUtil.paramCheck(blogForm, 3);
        List<BlogVO> list = new ArrayList<>();
        blogService.list(blogForm.getHostId())
                .forEach(o -> {
                    BlogVO blogVO = new BlogVO();
                    BeanUtils.copyProperties(o, blogVO);
                    list.add(blogVO);
                });
        return ResultVOUtil.success(list);
    }

    @PostMapping(value = "/open")
    public ResultVO<BlogVO> open(@RequestBody BlogForm blogForm) {
        ReflectionCheckUtil.paramCheck(blogForm, 1);
        Blog blog = new Blog();
        blog.setId(blogForm.getId());
        BlogVO blogVO = new BlogVO();
        BeanUtils.copyProperties(blogService.open(blog), blogVO);
        return ResultVOUtil.success(blogVO);
    }
}
