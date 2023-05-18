package com.cqut.atao.farm.order.domain.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SendProductReq.java
 * @Description 订单发货
 * @createTime 2023年04月23日 08:51:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendProductReq {

    @ApiModelProperty("订单号")
    private String orderSn;

    @ApiModelProperty("快递公司")
    private String deliveryCompany;

    @ApiModelProperty("快递编号")
    private String deliverySn;

    private Integer status;
}
