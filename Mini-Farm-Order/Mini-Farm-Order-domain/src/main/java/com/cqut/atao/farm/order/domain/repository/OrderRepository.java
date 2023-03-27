package com.cqut.atao.farm.order.domain.repository;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;

import java.util.List;


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
     * 状态流转
     * @param orderId 订单号
     * @param currentState 当前状态
     * @param nextState 下一状态
     * @return 结果
     */
    boolean alterState(String orderId, Enum<Constants.OrderState> currentState, Enum<Constants.OrderState> nextState);

    /**
     * 获取父订单id下的所有订单
     * @param parentOrderId 父订单id
     * @return {@link Order}
     */
    List<Order> getSubOrder(String parentOrderId);


    /**
     * 根据订单id查找订单
     * @param orderId 订单id
     * @return {@link Order}
     */
    Order selectOrderByOrderId(String orderId);

    /**
     * 保存订单
     * @param order {@link Order}
     */
    void saveParentOrder(Order order);
}
