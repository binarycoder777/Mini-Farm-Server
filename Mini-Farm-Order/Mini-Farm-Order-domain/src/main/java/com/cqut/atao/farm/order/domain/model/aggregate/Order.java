package com.cqut.atao.farm.order.domain.model.aggregate;

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
 * @ClassName Order.java
 * @Description 订单聚合类
 * @createTime 2023年02月04日 15:50:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    /**
     * 订单id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    private BigDecimal freightAmount;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 订单来源
     */
    private Integer source;

    /**
     * 订单类型 0：正常订单 1：秒杀订单 2：促销订单
     */
    private Integer type;

    /**
     * 自动确认天数
     */
    private Integer autoConfirmDay;

    /**
     * 物流公司
     */
    private String deliveryCompany;

    /**
     * 物流单号
     */
    private String deliverySn;

    /**
     * 收货人信息
     */
    private Address address;

    /**
     * 订单备注信息
     */
    private String remark;

    /**
     * 收货状态 0：未接收 1：已接收
     */
    private Integer confirmFlag;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 订单商品集合
     */
    private List<OrderProduct> orderProducts;

    // 暂未加入优惠卷和满减等规则
    public boolean caculatePayAmount() {
        BigDecimal currentAmount = new BigDecimal("0");
        for (OrderProduct orderProduct: orderProducts) {
            currentAmount = currentAmount.add(orderProduct.getProductPrice());
        }
        return payAmount.equals(currentAmount);
    }

}
