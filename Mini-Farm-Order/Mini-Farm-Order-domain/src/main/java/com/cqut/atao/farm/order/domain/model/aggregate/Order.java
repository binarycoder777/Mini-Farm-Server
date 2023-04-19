package com.cqut.atao.farm.order.domain.model.aggregate;

import com.cqut.atao.farm.order.domain.remote.model.res.CouponRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Order.java
 * @Description 订单聚合类
 * @createTime 2023年02月04日 15:50:00
 */
@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * 订单id
     */
    private String id;

    /**
     * 父订单id
     */
    private String parentId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 优惠卷Sn
     */
    private String couponSn;

    /**
     * 优惠券优惠金额
     */
    private BigDecimal couponTick;

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
     * 订单状态
     */
    private Integer status;

    /**
     * 订单备注信息
     */
    private String remark;

    /**
     * 收货人信息
     */
    private Address address;

    /**
     * 物流信息
     */
    private DeliveryInfo deliveryInfo;

    /**
     * 订单商品集合
     */
    private List<OrderProduct> orderProducts;


    // 暂未加入优惠卷和满减等规则
    public boolean caculatePayAmount() {
        BigDecimal currentAmount = new BigDecimal("0");
        for (OrderProduct orderProduct: orderProducts) {
            currentAmount = currentAmount.add(orderProduct.getProductPrice().multiply(BigDecimal.valueOf(orderProduct.getProductQuantity())));
        }
        return payAmount.subtract(currentAmount).intValue() < 1;
    }

    /**
     * 克隆订单（主要是替换订单对应的商品和价格之流，其余收货信息等不变）
     * @param orderProducts
     * @return
     */
    public Order generateSubOrder(List<OrderProduct> orderProducts){
        String sn = this.generateOrderSn();
        orderProducts.forEach(e->{
            e.setOrderSn(sn);
        });
        return Order.builder()
                .parentId(parentId)
                .orderProducts(orderProducts)
                .address(address)
                .freightAmount(freightAmount)
                .couponSn(couponSn)
                .couponTick(couponTick)
                .orderSn(sn)
                .payAmount(payAmount)
                .payTime(payTime)
                .payType(payType)
                .source(source)
                .remark(remark)
                .status(status)
                .type(type)
                .totalAmount(totalAmount)
                .userId(userId)
                .build();
    }

    /**
     * 订单id生成(后续改为自增)
     * @return 订单id
     */
    public String generateOrderId() {
        return UUID.randomUUID().toString();
    }


    /**
     * 订单号生成
     * @return 订单号
     */
    public String generateOrderSn() {
        return UUID.randomUUID().toString();
    }

}
