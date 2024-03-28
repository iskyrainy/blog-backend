package com.example.bb.controller;

import com.example.bb.constant.TokenConstant;
import com.example.bb.dataobject.User;
import com.example.bb.enums.CodeEnum;
import com.example.bb.exception.BlogException;
import com.example.bb.form.UserForm;
import com.example.bb.service.UserService;
import com.example.bb.utils.ArgonUtil;
import com.example.bb.utils.CookieUtil;
import com.example.bb.utils.ReflectionCheckUtil;
import com.example.bb.utils.ResultVOUtil;
import com.example.bb.vo.ResultVO;
import com.example.bb.vo.UserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>className: com.example.bb.controller-UserController
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
@RestController(value = "/user")
@CrossOrigin
@Slf4j
public class UserController {
    @Resource
    UserService userService;

    @PostMapping(value = "login")
    public ResultVO<UserVO> login(@RequestBody UserForm userForm) {
        try {
            if (ReflectionCheckUtil.paramCheck(userForm, 1, 2)) {
                log.error("PARAMS ERROR: {}", userForm.toString());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            User user = new User();
            user.setUsername(userForm.getUsername());
            user.setPassword(userForm.getPassword());
            String token = userService.login(user);
            if (token == null)
                return ResultVOUtil.error("login error: user is locked or password not correct!", null);
            UserVO userVO = new UserVO();
            userVO.setToken(token);
            return ResultVOUtil.success(userVO);
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/register")
    public ResultVO<String> register(@RequestBody UserForm userForm) {
        try {
            if (ReflectionCheckUtil.paramCheck(userForm, 1, 2, 3, 4)) {
                log.error("PARAMS ERROR: {}", userForm.toString());
                throw new BlogException(CodeEnum.PARAM_ERROR);
            }
            User user = new User();
            user.setTypeId(userForm.getTypeId());
            user.setPhone(userForm.getPhone());
            user.setUsername(userForm.getUsername());
            user.setPassword(ArgonUtil.encode(userForm.getPassword()));
            String register = userService.register(user);
            if (register == null)
                return ResultVOUtil.error("user has been registered", null);
            else
                return ResultVOUtil.success(register);
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

    @PostMapping(value = "/logout")
    public ResultVO<String> logout(HttpServletRequest request) {
        try {
            Cookie token = CookieUtil.get(request, TokenConstant.TOKEN);
            return ResultVOUtil.success(userService.logout(token), null);
        } catch (BlogException e) {
            return ResultVOUtil.error(e.getMessage(), null);
        }
    }

}
