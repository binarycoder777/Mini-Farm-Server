package com.cqut.atao.farm.user.domain.service;

import com.cqut.atao.farm.user.domain.model.res.LoginRes;

import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description 用户服务接口
 * @createTime 2023年01月12日 20:08:00
 */
public interface UserService {

    LoginRes login(Map<String,String> data);

}
