package com.cqut.atao.farm.order.domain.split.filter;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import com.cqut.atao.farm.order.domain.split.OrderSplitAbstract;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MerchantSplit.java
 * @Description 按商家拆分订单
 * @createTime 2023年02月26日 23:35:00
 */

@Component
public class MerchantFilter extends OrderSplitAbstract {

    @Override
    public List<Order> splitOrder(Order order) {
        // 商家ID ---> 订单商品
        Map<Long, List<OrderProduct>> map = Collections.emptyMap();
        // 按商家进行分类商品
        order.getOrderProducts().stream().forEach(e -> {
            List<OrderProduct> orDefault = map.getOrDefault(e.getMerchantId(), Collections.emptyList());
            orDefault.add(e);
        });
        // 拆分后的订单
        List<Order> orders = Collections.emptyList();
        // 无需在拆分订单
        if (next() == null) {
            // 将同一商家的商品组装成一份订单
            map.values().forEach(e -> {
                Order subOrder = order.generateSubOrder(e);
                orders.add(subOrder);
            });
            return orders;
        }
        // 还需要再拆分订单
        map.values().forEach(e -> {
            Order subOrder = order.generateSubOrder(e);
            List<Order> splitOrders = next().splitOrder(subOrder);
            orders.addAll(splitOrders);
        });
        return orders;
    }

}
