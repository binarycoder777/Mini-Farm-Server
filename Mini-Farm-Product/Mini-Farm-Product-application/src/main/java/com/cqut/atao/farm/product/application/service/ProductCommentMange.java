package com.cqut.atao.farm.product.application.service;


import com.cqut.atao.farm.product.domain.mode.req.AddCommentReq;
import com.cqut.atao.farm.product.domain.mode.req.CommentProductReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCommentReq;
import com.cqut.atao.farm.product.domain.mode.res.CommentRes;
import com.cqut.atao.farm.product.domain.mode.res.CommentStatisticsRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCommentMange.java
 * @Description 商品评论管理接口
 * @createTime 2023年04月08日 13:56:00
 */
public interface ProductCommentMange {

    /**
     * 进行评论
     * @param req
     */
    void doComment(CommentProductReq req);

    /**
     * 分类统计
     * @param productSpuId
     * @return
     */
    List<CommentStatisticsRes> categoryStatisticsComment(Long productSpuId);

    /**
     * 分页查询
     * @param req
     * @return
     */
    PageResponse<CommentRes> pageQueryComment(PageCommentReq req);

    /**
     * 统计商品评论数
     * @param productId
     * @return
     */
    Long countProductCommentNums(Long productId);
}
