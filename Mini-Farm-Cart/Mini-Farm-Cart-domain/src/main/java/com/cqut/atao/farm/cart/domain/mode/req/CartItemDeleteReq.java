package com.cqut.atao.farm.cart.domain.mode.req;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemClearReq.java
 * @Description 购物车清空请求
 * @createTime 2023年02月02日 20:15:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDeleteReq {

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("skuid列表")
    private List<Long> skuIds;
}
