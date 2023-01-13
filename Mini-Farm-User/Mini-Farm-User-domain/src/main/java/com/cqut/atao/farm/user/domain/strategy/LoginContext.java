package com.cqut.atao.farm.user.domain.strategy;

import com.cqut.atao.farm.user.common.constant.Constants;
import com.cqut.atao.farm.user.domain.strategy.policy.VxLoginStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName LoginContext.java
 * @Description 登录上下文
 * @createTime 2023年01月13日 16:49:00
 */
@Configuration
public class LoginContext {


    @Bean
    public Map<Constants.LoginStrategy, LoginStrategy> loginStrategy(VxLoginStrategy vxLoginStrategy) {
        Map<Constants.LoginStrategy, LoginStrategy> res = new HashMap<>(8);
        res.put(Constants.LoginStrategy.VX,vxLoginStrategy);
        return res;
    }

}
