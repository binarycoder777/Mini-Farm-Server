package com.cqut.atao.farm.order.domain.split;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderSplit.java
 * @Description 订单拆分接口
 * @createTime 2023年02月26日 23:18:00
 */
public interface OrderSplit {

    List<Order> splitOrder(Order order);

}
