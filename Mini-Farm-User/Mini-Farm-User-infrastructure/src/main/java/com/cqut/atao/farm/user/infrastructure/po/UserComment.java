package com.cqut.atao.farm.user.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserComment.java
 * @Description 用户评论
 * @createTime 2023年03月27日 21:53:00
 */
@Data
@TableName("user_comment")
public class UserComment extends BaseDO {

    /**
     * id
     */
    private Long id;

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
