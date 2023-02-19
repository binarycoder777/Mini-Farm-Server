package com.cqut.atao.farm.user.application.service;

import com.cqut.atao.farm.user.domain.model.req.BaseLoginReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;

import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IUserService.java
 * @Description 用户服务接口
 * @createTime 2023年01月12日 21:06:00
 */
public interface UserMange {

    /**
     * 用户登录
     * @param data {@link Map}
     * @return {@link LoginRes}
     */
    LoginRes login(BaseLoginReq req);


}
