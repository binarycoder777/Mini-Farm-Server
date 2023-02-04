package com.cqut.atao.farm.order.application.process.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateOrderReq.java
 * @Description 创建订单请求
 * @createTime 2023年02月04日 15:40:00
 */
@Data
public class CreateOrderReq {

    @ApiModelProperty("用户id")
    private String customerUserId;

    @ApiModelProperty("订单总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty("支付金额")
    private BigDecimal payAmount;

    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;

    @ApiModelProperty("订单来源")
    private Integer source;

    @ApiModelProperty("订单类型 0：正常订单 1：秒杀订单 2：促销订单")
    private Integer type;

    @ApiModelProperty("收货人")
    private String cneeName;

    @ApiModelProperty("收货人电话")
    private String cneePhone;

    @ApiModelProperty("收货人邮编")
    private String cneePostCode;

    @ApiModelProperty("收货人所在省")
    private String cneeProvinc;

    @ApiModelProperty("收货人所在市")
    private String cneeCity;

    @ApiModelProperty("收货人所在区")
    private String cneeRegion;

    @ApiModelProperty("收货人详细地址")
    private String cneeDetailAddress;

    @ApiModelProperty("订单备注信息")
    private String remark;
}
