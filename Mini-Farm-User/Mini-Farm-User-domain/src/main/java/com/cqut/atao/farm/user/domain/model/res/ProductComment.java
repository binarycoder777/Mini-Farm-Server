package com.cqut.atao.farm.user.domain.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductComment.java
 * @Description 商品评论
 * @createTime 2023年03月28日 09:02:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductComment {

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
