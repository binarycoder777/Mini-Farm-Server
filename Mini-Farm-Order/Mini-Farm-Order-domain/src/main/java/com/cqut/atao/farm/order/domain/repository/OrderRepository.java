package com.cqut.atao.farm.order.domain.repository;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderRepository.java
 * @Description 订单仓储层
 * @createTime 2023年02月04日 16:57:00
 */
public interface OrderRepository {

    /**
     * 保存订单
     * @param order {@link Order}
     */
    void saveOrder(Order order);

    /**
     * 保存订单商品详情
     * @param order {@link Order}
     */
    void saveOrderItem(Order order);

}
