package com.cqut.atao.farm.cart.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemSelectedReq.java
 * @Description 修改购物车商品勾选状态入参
 * @createTime 2023年02月02日 20:44:00
 */
@Data
public class CartItemSelectedReq {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("选中标志")
    private Integer selectFlag;
}
