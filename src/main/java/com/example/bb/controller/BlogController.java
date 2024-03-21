package com.example.bb.controller;

import com.example.bb.dataobject.Blog;
import com.example.bb.enums.CodeEnum;
import com.example.bb.exception.BlogException;
import com.example.bb.form.BlogForm;
import com.example.bb.service.BlogService;
import com.example.bb.utils.ResultVOUtil;
import com.example.bb.vo.ResultVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultVO<Blog> create(@Validated @RequestBody BlogForm blogForm,
                                 BindingResult result) {
        try {
            if (result.hasErrors()) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getHostId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/update")
    public ResultVO<Boolean> update(@Validated @RequestBody BlogForm blogForm,
                           BindingResult result) {
        try {
            if (result.hasErrors()) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getHostId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/delete")
    public ResultVO<Boolean> delete(@Validated @RequestBody BlogForm blogForm,
                           BindingResult result) {
        try {
            if (result.hasErrors()) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getHostId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/list")
    public ResultVO list(@Validated @RequestBody BlogForm blogForm,
                           BindingResult result) {
        try {
            if (result.hasErrors()) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getHostId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/open")
    public ResultVO open(@Validated @RequestBody BlogForm blogForm,
                           BindingResult result) {
        try {
            if (result.hasErrors()) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getHostId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }
}
