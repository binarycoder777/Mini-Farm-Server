package com.cqut.atao.farm.product.domain.mode.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName EsProductPo.java
 * @Description 商品持久类(ES存储)
 * @createTime 2023年02月11日 14:51:00
 */
@Document(indexName = "e_product", shards = 3, replicas = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EsProduct {

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
