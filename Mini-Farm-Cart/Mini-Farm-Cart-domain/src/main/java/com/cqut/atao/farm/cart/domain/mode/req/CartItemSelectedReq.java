package com.cqut.atao.farm.cart.domain.mode.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemSelectedReq.java
 * @Description 修改购物车商品勾选状态入参
 * @createTime 2023年02月02日 20:44:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemSelectedReq {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("选中标志")
    private Integer selectFlag;
}
