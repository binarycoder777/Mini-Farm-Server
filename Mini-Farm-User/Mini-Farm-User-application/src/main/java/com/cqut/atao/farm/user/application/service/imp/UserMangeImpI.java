package com.cqut.atao.farm.user.application.service.imp;

import com.cqut.atao.farm.user.domain.model.req.BaseLoginReq;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.service.UserService;
import com.cqut.atao.farm.user.application.service.UserMange;
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
public class UserMangeImpI implements UserMange {

    @Resource
    private UserService userService;

    @Override
    public LoginRes login(BaseLoginReq req) {
        return userService.login(req);
    }

    @Override
    public void collecteProduct(CollectProductReq req) {
        userService.collectProduct(req);
    }

    @Override
    public void commentProduct(CommentProductReq req) {
        userService.commentProduct(req);
    }
}
