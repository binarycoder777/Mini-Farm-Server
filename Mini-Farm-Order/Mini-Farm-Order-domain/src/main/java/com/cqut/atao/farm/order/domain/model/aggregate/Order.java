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
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 收货状态 0：未接收 1：已接收
     */
    private Integer confirmFlag;

    /**
     * 订单商品集合
     */
    private List<OrderProduct> orderProducts;

    /**
     * 优惠卷Sn
     */
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

    private Date createTime;


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
                .freightAmount(freightAmount)
                .couponSn(couponSn)
                .couponAmount(couponAmount)
                .promotionSn(promotionSn)
                .useIntegration(useIntegration)
                .integrationAmount(integrationAmount)
                .promotionAmount(promotionAmount)
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
                .cneeCity(cneeCity)
                .cneeName(cneeName)
                .cneeRegion(cneeRegion)
                .cneeDetailAddress(cneeDetailAddress)
                .cneePhone(cneePhone)
                .cneePostCode(cneePostCode)
                .cneeProvinc(cneeProvinc)
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
