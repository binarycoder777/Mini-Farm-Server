package com.cqut.atao.farm.order.domain.model.req;


import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PlaceOrderReq.java
 * @Description 下单请求
 * @createTime 2023年02月27日 14:28:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderReq {

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 收货人
     */
    private String cneeName;

    /**
     * 收货人电话
     */
    private String cneePhone;

    /**
     * 收货人邮编
     */
    private String cneePostCode;

    /**
     * 收货人所在省
     */
    private String cneeProvinc;

    /**
     * 收货人所在市
     */
    private String cneeCity;

    /**
     * 收货人所在区
     */
    private String cneeRegion;

    /**
     * 收货人详细地址
     */
    private String cneeDetailAddress;

    /**
     * 收货时间
     */
    private Date receiveTime;

    /**
     * 订单商品集合
     */
    @ApiModelProperty("订单商品集合")
    private List<OrderProduct> orderProducts;

    /**
     * 运费金额
     */
    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;

    /**
     * 订单总金额
     */
    @ApiModelProperty("订单总金额")
    private BigDecimal totalAmount;

    /**
     * 支付金额
     */
    @ApiModelProperty("支付金额")
    private BigDecimal payAmount;

    /**
     * 支付方式(组合支付、普通支付、差补支付)
     */
    @ApiModelProperty("支付方式(组合支付、普通支付、差补支付)")
    private Integer payType;

    /**
     * 订单来源
     */
    @ApiModelProperty("订单来源")
    private Integer source;

    /**
     * 订单类型 0：正常订单 1：秒杀订单 2：促销订单
     */
    @ApiModelProperty("订单类型 0：正常订单 1：秒杀订单 2：促销订单")
    private Integer type;

    /**
     * 优惠卷id
     */
    @ApiModelProperty("优惠卷Sn")
    private String couponSn;

    /**
     * 优惠券抵扣金额 | 分摊优惠
     */
    private BigDecimal couponAmount;

    /**
     * 促销活动编码
     */
    private Long promotionSn;
    /**
     * 促销金额 | 分摊优惠
     */
    private BigDecimal promotionAmount;

    /**
     * 使用积分
     */
    private Integer useIntegration;

    /**
     * 积分抵扣金额
     */
    private BigDecimal integrationAmount;

}
