package com.cqut.atao.farm.order.domain.split.special;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Caculator.java
 * @Description 拆单后的优惠信息分摊计算器
 * @createTime 2023年02月27日 10:53:00
 */
@Component
public class Caculator implements SpecialSplit {

    /**
     * 子订单分摊金额=sum(单个商品SKU总金额/父订单总金额*优惠总金额)
     * @param order {@link Order}
     * @return {@link Order}
     */
    @Override
    public Order cacualte(Order order) {
        // 订单总金额
        BigDecimal orderTotalAmount = new BigDecimal("0");
        // 订单实付金额
        BigDecimal orderPayAmount = new BigDecimal("0");
        for (OrderProduct orderProduct: order.getOrderProducts()) {
            // 单品总金额
            BigDecimal totalAmount = orderProduct.getProductPrice().multiply(BigDecimal.valueOf(orderProduct.getProductQuantity()));
            // 单品优惠(远程调用营销服务获取)
            BigDecimal specialAmount = new BigDecimal("0");
            // 满减优惠(远程调用营销服务获取)
            BigDecimal fullSubtractionAmount = new BigDecimal("0");
            // 满减分摊优惠
            BigDecimal fullSubtractionSplitAmount = (totalAmount.subtract(specialAmount)).divide(order.getTotalAmount()).max(fullSubtractionAmount);
            // 优惠卷优惠(远程调用营销服务获取)
            BigDecimal couponAmount = new BigDecimal("0");
            // 优惠券分摊优惠
            BigDecimal couponSplitAmount = (totalAmount.subtract(couponAmount)).divide(order.getTotalAmount()).max(fullSubtractionAmount);
            // 子订单实付款
            BigDecimal payAmount = totalAmount.subtract(specialAmount).subtract(fullSubtractionSplitAmount).subtract(couponSplitAmount);
            // 相加
            orderTotalAmount = orderTotalAmount.add(totalAmount);
            orderPayAmount = orderPayAmount.add(payAmount);
        }
        // 注入总金额和实付金额
        order.setTotalAmount(orderTotalAmount);
        order.setPayAmount(orderPayAmount);
        return order;
    }
}
