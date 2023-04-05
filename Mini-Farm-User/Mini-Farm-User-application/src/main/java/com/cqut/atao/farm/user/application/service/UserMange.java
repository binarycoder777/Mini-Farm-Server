package com.cqut.atao.farm.user.application.service;

import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.user.domain.model.req.BaseLoginReq;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductPageReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.res.ProductComment;
import com.cqut.atao.farm.user.domain.model.res.UserInfoRes;

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
     * 获取收藏商品状态
     * @param userId 用户id
     * @param productId 商品id
     * @return true/false
     */
    boolean getProductCollectStatus(Long userId,Long productId);

    /**
     * 用户评论商品
     * @param req {@link CommentProductReq}
     */
    void commentProduct(CommentProductReq req);

    /**
     * 商品评论分页
     * @param req 分页请求
     * @return 分页结果
     */
    PageResponse<ProductComment> productCommentPage(CommentProductPageReq req);

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    UserInfoRes queryUserInfo(Long userId);

}
