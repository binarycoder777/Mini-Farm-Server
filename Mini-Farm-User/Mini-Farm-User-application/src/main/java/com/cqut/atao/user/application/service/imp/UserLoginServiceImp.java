package com.cqut.atao.user.application.service.imp;

import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.service.UserService;
import com.cqut.atao.user.application.service.UserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserServiceImp.java
 * @Description 用户服务
 * @createTime 2023年01月12日 21:06:00
 */
@Service
public class UserLoginServiceImp implements UserLoginService {

    @Resource
    private UserService userService;

    public LoginRes login(Map<String, String> data) {
        return userService.login(data);
    }
}
