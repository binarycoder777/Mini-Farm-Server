package com.cqut.atao.farm.product.domain.mode.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CommentProductReq.java
 * @Description 评论商品请求
 * @createTime 2023年04月09日 16:00:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentProductReq {

    /**
     * 评论订单
     */
    private String orderSn;

    /**
     * 评论列表
     */
    private List<AddCommentReq> comments;

}
