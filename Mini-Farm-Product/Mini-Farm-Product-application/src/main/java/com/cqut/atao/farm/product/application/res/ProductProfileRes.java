package com.cqut.atao.farm.product.application.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductProfileRes.java
 * @Description 商品简介
 * @createTime 2023年02月11日 11:02:00
 */
@Data
public class ProductProfileRes {

    @ApiModelProperty("商品id")
    private String id;

    @ApiModelProperty("商品类型id")
    private String categoryId;

    @ApiModelProperty("商品品牌id")
    private String brandId;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品编码")
    private String productSn;

    @ApiModelProperty("商品主图")
    private String pic;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("促销价格")
    private BigDecimal promotionPrice;

    @ApiModelProperty("促销开始时间")
    private Date promotionStartTime;

    @ApiModelProperty("促销结束时间")
    private Date promotionEndTime;

    @ApiModelProperty("副标题")
    private String subTitle;

    @ApiModelProperty("销量")
    private Integer sales;

    @ApiModelProperty("单位")
    private String unit;

}
