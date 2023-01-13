package com.cqut.atao.user.web.controller;

import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.user.application.service.UserLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "用户服务")
public class UserController {

    @Resource
    private UserLogin userLogin;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<LoginRes> login(@RequestBody Map<String,String> map) {
        LoginRes result = userLogin.login(map);
        return Results.success(result);
    }

}
