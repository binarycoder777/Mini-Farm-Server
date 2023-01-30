package com.cqut.atao.farm.product.domain.mode.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductSpuVO.java
 * @Description 商品 SPU
 * @createTime 2023年01月30日 19:41:00
 */
@Data
public class ProductSpuVO {

    /**
     * id
     */
    private Long id;

    /**
     * 商品类型id
     */
    private Long categoryId;

    /**
     * 商品品牌id
     */
    private Long brandId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品编码
     */
    private String productSn;

    /**
     * 商品主图
     */
    private String pic;

    /**
     * 商品图集
     */
    private String photoAlbum;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 促销价格
     */
    private BigDecimal promotionPrice;

    /**
     * 促销开始时间
     */
    private Date promotionStartTime;

    /**
     * 促销结束时间
     */
    private Date promotionEndTime;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 单位
     */
    private String unit;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 发布状态 0：发布 1：未发布
     */
    private Integer publishStatus;

    /**
     * 新品状态 0：新品 1：非新品
     */
    private Integer newStatus;

    /**
     * 推荐状态 0：推荐 1：非推荐
     */
    private Integer recommandStatus;
}

