package com.cqut.atao.farm.user.domain.service;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.user.domain.model.req.BaseLoginReq;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.res.ProductComment;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description 用户服务接口
 * @createTime 2023年01月12日 20:08:00
 */
public interface UserService {

    /**
     * 登录服务
     * @param req 跟进不同的策略获取数据
     * @return {@link LoginRes}
     */
    LoginRes login(BaseLoginReq req);

    /**
     * 用户收藏/取消收藏商品
     * @param req
     */
    void collectProduct(CollectProductReq req);

    /**
     * 评论商品
     * @param req {@link CommentProductReq}
     */
    void commentProduct(CommentProductReq req);


    /**
     * 商品评论分页
     * @param productId 商品id
     * @param req 分页请求
     * @return 分页结果
     */
    PageResponse<ProductComment> productCommentPage(Long productId,PageRequest req);
}
