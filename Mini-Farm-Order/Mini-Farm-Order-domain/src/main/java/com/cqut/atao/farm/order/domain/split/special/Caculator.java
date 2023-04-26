package com.cqut.atao.farm.order.domain.split.special;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Caculator.java
 * @Description 拆单后的优惠信息分摊计算器
 * @createTime 2023年02月27日 10:53:00
 */
@Slf4j
@Component
public class Caculator implements SpecialSplit {

    /**
     * 子订单分摊金额=sum(单个商品SKU总金额/父订单总金额*优惠总金额)
     *
     * @param order {@link Order}
     * @return {@link Order}
     */
    @Override
    public Order cacualte(Order order) {
        log.info("{}",order);
        // 优惠总金额
        BigDecimal promitionTotal = order.getCouponAmount()
                .add(order.getPromotionAmount())
                .add(order.getIntegrationAmount());
        // 子订单优惠金额
        BigDecimal promitionTotalAmount = new BigDecimal("0");
        // 子订总的金额
        BigDecimal skuTotalAmount = new BigDecimal("0");
        // todo 这里计算有问题
        for (OrderProduct orderProduct : order.getOrderProducts()) {
            // 单品总金额
            BigDecimal totalAmount = orderProduct.getProductPrice().multiply(BigDecimal.valueOf(orderProduct.getProductQuantity()));
            skuTotalAmount = skuTotalAmount.add(totalAmount);
            // 单品优惠
            BigDecimal multiply = totalAmount.divide(order.getTotalAmount(),3, BigDecimal.ROUND_HALF_UP).multiply(promitionTotal);
            promitionTotalAmount = promitionTotalAmount.add(multiply);
        }
        // 注入总金额和实付金额
        order.setTotalAmount(skuTotalAmount.add(order.getFreightAmount()));
        order.setPayAmount(order.getTotalAmount().subtract(promitionTotalAmount));
        return order;
    }
}
