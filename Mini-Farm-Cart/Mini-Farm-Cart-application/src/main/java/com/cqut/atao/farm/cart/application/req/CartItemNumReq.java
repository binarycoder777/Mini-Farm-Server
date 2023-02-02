package com.cqut.atao.farm.cart.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemNumReq.java
 * @Description 购物车商品数量请求
 * @createTime 2023年02月02日 19:38:00
 */
@Data
public class CartItemNumReq {

    @ApiModelProperty("商品 spu id")
    private String productId;

    @ApiModelProperty("商品 sku id")
    private String productSkuId;

    @ApiModelProperty("c 端用户 id")
    private String customerUserId;

    @ApiModelProperty("加购物车数量")
    private Integer productQuantity;
}
