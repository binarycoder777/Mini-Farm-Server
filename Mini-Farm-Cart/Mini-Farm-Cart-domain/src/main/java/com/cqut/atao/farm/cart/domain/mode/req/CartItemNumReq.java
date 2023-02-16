package com.cqut.atao.farm.cart.domain.mode.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemNumReq.java
 * @Description 购物车商品数量请求
 * @createTime 2023年02月02日 19:38:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemNumReq {

    @ApiModelProperty("购物车商品id")
    private Long id;

    @ApiModelProperty("加购物车数量")
    private Integer productQuantity;
}
