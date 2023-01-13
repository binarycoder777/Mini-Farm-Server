package com.cqut.atao.farm.user.domain.strategy;

import com.cqut.atao.farm.user.domain.model.res.LoginRes;

import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName LoginStrategy.java
 * @Description 登录策略接口
 * @createTime 2023年01月13日 16:46:00
 */
public interface LoginStrategy{

    LoginRes login(Map<String,String> data);

}
