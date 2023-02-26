package com.cqut.atao.farm.order.domain.split.filter;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.split.OrderSplitAbstract;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MerchantSplit.java
 * @Description 按商家拆分订单
 * @createTime 2023年02月26日 23:35:00
 */
@Component
public class MerchantFilter extends OrderSplitAbstract {

    public MerchantFilter(OrderSplitAbstract next) {
        super(next);
    }

    public List<Order> splitOrder(Order order) {
        return null;
    }

}
