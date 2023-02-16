package com.cqut.atao.farm.cart.domain.mode.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemAddReq.java
 * @Description 购物车商品新增请求
 * @createTime 2023年02月02日 20:42:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemAddReq {
    @ApiModelProperty("商品 spu id")
    private String productId;

    @ApiModelProperty("商品 sku id")
    private String productSkuId;

    @ApiModelProperty("c 端用户 id")
    private String userId;

    @ApiModelProperty("商品图")
    private String productPic;

    @ApiModelProperty("商品名称")
    private String productName;

    @ApiModelProperty("商品品牌")
    private String productBrand;

    @ApiModelProperty("商品价格")
    private BigDecimal productPrice;

    @ApiModelProperty("加购物车数量")
    private Integer productQuantity;

    @ApiModelProperty("商品规格，json 格式")
    private String productAttribute;

    @ApiModelProperty("选中标志")
    private Integer selectFlag;
}

