package com.cqut.atao.farm.product.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCommentPO.java
 * @Description 商品评论持久类
 * @createTime 2023年04月08日 13:38:00
 */
@Data
@TableName("product_comment")
public class ProductCommentPO extends BaseDO {


    /**
     * id
     */
    private Long id;

    /**
     * 评论类型（好评、差评等）
     */
    private Integer type;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * sku id
     */
    private Long productSkuId;


    /**
     * sku 对应规格
     */
    private String spec;

    /**
     * 商品评分
     */
    private Integer star;

    /**
     * 态度评分
     */
    private Integer attitude;
    /**
     * 物流评分
     */
    private Integer logistics;
    /**
     * 速度评分
     */
    private Integer speed;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 是否匿名
     */
    private boolean hideFlag;

    /**
     * 图片
     */
    private String pics;

    /**
     * 视频
     */
    private String video;



}
