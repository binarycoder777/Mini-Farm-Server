package com.cqut.atao.farm.product.application.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductSkuRes.java
 * @Description 商品 SKU
 * @createTime 2023年01月31日 19:23:00
 */
@Data
public class ProductSkuRes {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("商品 id")
    private String productId;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty("锁定库存")
    private Integer lockStock;

    @ApiModelProperty("图片")
    private String pic;

    @ApiModelProperty("属性，json 格式")
    private String attribute;
}
