package com.cqut.atao.farm.user.application.service.imp;

import com.alibaba.fastjson2.JSON;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.user.domain.model.req.BaseLoginReq;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductPageReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.res.ProductComment;
import com.cqut.atao.farm.user.domain.model.res.UserInfoRes;
import com.cqut.atao.farm.user.domain.repository.UserRepository;
import com.cqut.atao.farm.user.domain.service.UserService;
import com.cqut.atao.farm.user.application.service.UserMange;
import com.cqut.atao.farm.user.domain.util.VxUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class UserMangeImpI implements UserMange {

    @Resource
    private UserService userService;

    @Resource
    private UserRepository userRepository;

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

    @Override
    public PageResponse<ProductComment> productCommentPage(CommentProductPageReq req) {
        return userService.productCommentPage(req.getProductId(),req);
    }

    @Override
    public boolean getProductCollectStatus(Long userId, Long productId) {
        return userRepository.getCollectProductStatus(userId,productId);
    }

    @Override
    public UserInfoRes queryUserInfo(Long userId) {
        return userRepository.findUserInfo(userId);
    }

    @Override
    public UserInfoRes queryUserInfoByAuthorzation(String authorzation) {
        Claims claimByToken = VxUtil.getClaimByToken(authorzation);
        Object userId = JSON.parseObject(claimByToken.getSubject()).get("userId");
        if (userId instanceof Integer) {
            return queryUserInfo(Long.valueOf((Integer)userId));
        }
        return queryUserInfo(Long.valueOf((Long) userId));
    }
}
