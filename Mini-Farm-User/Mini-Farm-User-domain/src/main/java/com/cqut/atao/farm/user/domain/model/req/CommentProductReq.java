package com.cqut.atao.farm.user.domain.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CommentProductReq.java
 * @Description 评论商品请求
 * @createTime 2023年03月27日 22:04:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentProductReq {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userIcon;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * sku
     */
    private String spec;

    /**
     * 评分
     */
    private Integer grade;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 图片
     */
    private String img;

    /**
     * 视频
     */
    private String video;

}
