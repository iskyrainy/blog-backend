package com.example.bb.controller;

import com.example.bb.enums.CodeEnum;
import com.example.bb.exception.BlogException;
import com.example.bb.form.BlogForm;
import com.example.bb.service.BlogService;
import com.example.bb.utils.ReflectionCheckUtil;
import com.example.bb.utils.ResultVOUtil;
import com.example.bb.vo.BlogVO;
import com.example.bb.vo.ResultVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultVO<Boolean> create(@RequestBody BlogForm blogForm) {
        try {
            if (ReflectionCheckUtil.paramCheck(blogForm, 1, 2, 3)) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/update")
    public ResultVO<Boolean> update(@RequestBody BlogForm blogForm) {
        try {
            if (ReflectionCheckUtil.paramCheck(blogForm, 1)) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/delete")
    public ResultVO<Boolean> delete(@RequestBody BlogForm blogForm) {
        try {
            if (ReflectionCheckUtil.paramCheck(blogForm, 1)) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/list")
    public ResultVO<List<BlogVO>> list(@RequestBody BlogForm blogForm) {
        try {
            if (ReflectionCheckUtil.paramCheck(blogForm, 3)) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/open")
    public ResultVO<BlogVO> open(@RequestBody BlogForm blogForm) {
        try {
            if (ReflectionCheckUtil.paramCheck(blogForm, 1)) {
                log.error("PARAMS ERROR: {}:{}", blogForm.getTitle(), blogForm.getId());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            return null;
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }
}
