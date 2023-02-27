package com.cqut.atao.farm.order.domain.model.req;


import com.cqut.atao.farm.order.domain.model.aggregate.Address;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
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
public class PlaceOrderReq {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 收货人信息
     */
    private Address address;

    /**
     * 订单商品集合
     */
    private List<OrderProduct> orderProducts;

    /**
     * 优惠卷id
     */
    private Long couponId;

    /**
     * 满减活动id
     */
    private Long specialActivityId;

    /**
     * 优惠总金额
     */
    private BigDecimal specialTotalAmount;

    /**
     * 运费金额
     */
    private BigDecimal freightAmount;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 支付方式(组合支付、普通支付、差补支付)
     */
    private Integer payType;

    /**
     * 订单来源
     */
    private Integer source;

    /**
     * 订单类型 0：正常订单 1：秒杀订单 2：促销订单
     */
    private Integer type;

}
