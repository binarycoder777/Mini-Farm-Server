package com.cqut.atao.farm.user.application.service;

import com.cqut.atao.farm.user.domain.model.req.BaseLoginReq;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductReq;
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
     * @param req {@link Map}
     * @return {@link LoginRes}
     */
    LoginRes login(BaseLoginReq req);


    /**
     * 用户收藏/取消收藏商品请求
     * @param req {@link CollectProductReq}
     */
    void collecteProduct(CollectProductReq req);

    /**
     * 用户评论商品
     * @param req {@link CommentProductReq}
     */
    void commentProduct(CommentProductReq req);
}
