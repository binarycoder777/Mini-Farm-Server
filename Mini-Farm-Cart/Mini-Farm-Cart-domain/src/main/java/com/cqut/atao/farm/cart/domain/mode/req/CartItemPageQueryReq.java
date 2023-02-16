package com.cqut.atao.farm.cart.domain.mode.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemPageQueryReq.java
 * @Description 购物车分页查询请求
 * @createTime 2023年01月31日 21:32:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemPageQueryReq extends PageRequest {

    @ApiModelProperty("c 端用户 id")
    private String userId;

}
