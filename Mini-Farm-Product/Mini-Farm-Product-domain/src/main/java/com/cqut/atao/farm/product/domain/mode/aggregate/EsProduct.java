package com.cqut.atao.farm.product.domain.mode.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName EsProductPo.java
 * @Description 商品持久类(ES存储)
 * @createTime 2023年02月11日 14:51:00
 */
@Document(indexName = "product", shards = 3, replicas = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EsProduct {

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 商品类型id
     */
    @Field(type = FieldType.Long)
    private Long categoryId;

    /**
     * 商品品牌id
     */
    @Field(type = FieldType.Long)
    private Long brandId;

    /**
     * 商品名称
     */
    @Field(type = FieldType.Text, index = true)
    private String name;

    /**
     * 商品编码
     */
    @Field(type = FieldType.Text)
    private String productSn;

    /**
     * 商品主图
     */
    @Field(type = FieldType.Text)
    private String pic;

    /**
     * 商品价格
     */
    @Field(type = FieldType.Text)
    private BigDecimal price;

    /**
     * 促销价格
     */
    @Field(type = FieldType.Text)
    private BigDecimal promotionPrice;

    /**
     * 促销开始时间
     */
    @Field(type = FieldType.Text)
    private Date promotionStartTime;

    /**
     * 促销结束时间
     */
    @Field(type = FieldType.Text)
    private Date promotionEndTime;

    /**
     * 副标题
     */
    @Field(type = FieldType.Text, index = true)
    private String subTitle;

    /**
     * 销量
     */
    @Field(type = FieldType.Integer)
    private Integer sales;

    /**
     * 单位
     */
    @Field(type = FieldType.Text)
    private String unit;

    /**
     * 商品详情
     */
    @Field(type = FieldType.Text, index = true)
    private String detail;

    /**
     * 发布状态 0：发布 1：未发布
     */
    @Field(type = FieldType.Integer)
    private Integer publishStatus;

    /**
     * 新品状态 0：新品 1：非新品
     */
    @Field(type = FieldType.Integer)
    private Integer newStatus;

    /**
     * 推荐状态 0：推荐 1：非推荐
     */
    @Field(type = FieldType.Integer)
    private Integer recommandStatus;

}
