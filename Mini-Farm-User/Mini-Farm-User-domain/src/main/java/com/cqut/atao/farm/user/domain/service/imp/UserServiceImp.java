package com.cqut.atao.farm.user.domain.service.imp;

import com.cqut.atao.farm.user.common.constant.Constants;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.service.UserService;
import com.cqut.atao.farm.user.domain.strategy.LoginContext;
import com.cqut.atao.farm.user.domain.strategy.LoginStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserServiceImp.java
 * @Description 用户服务
 * @createTime 2023年01月12日 20:08:00
 */
@Service
public class UserServiceImp implements UserService {

    @Resource
    private Map<Constants.LoginStrategy, LoginStrategy> loginStrategy;

    @Override
    public LoginRes login(Map<String, String> data) {
        LoginStrategy strategy = null;
        // 1.获取登录类型
        String loginType = data.get("loginType");
        // 2.登录验证
        if (loginType .equals("VX")) {
            strategy = loginStrategy.get(Constants.LoginStrategy.VX);
        }
        return strategy.login(data);
    }

}
