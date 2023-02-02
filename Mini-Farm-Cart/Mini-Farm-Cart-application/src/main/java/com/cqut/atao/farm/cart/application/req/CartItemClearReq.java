package com.cqut.atao.farm.cart.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemClearReq.java
 * @Description 购物车清空请求
 * @createTime 2023年02月02日 20:15:00
 */
@Data
public class CartItemClearReq {

    @ApiModelProperty("用户ID")
    private String customerUserId;

    @ApiModelProperty("商品SKU集合")
    private List<String> skuIds;

}
