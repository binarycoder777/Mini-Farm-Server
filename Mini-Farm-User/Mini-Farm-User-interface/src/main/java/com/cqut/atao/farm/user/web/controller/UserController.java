package com.cqut.atao.farm.user.web.controller;

import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import com.cqut.atao.farm.user.domain.model.req.VxUserLoginReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.application.service.UserMange;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description 用户控制器
 * @createTime 2023年01月12日 19:39:00
 */
@Slf4j
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "用户服务")
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserMange userMange;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<LoginRes> login(@RequestBody VxUserLoginReq req) {
        LoginRes result = userMange.login(req);
        return Results.success(result);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<Void> register(@RequestBody Map<String,String> map) {
        return null;
    }

}
