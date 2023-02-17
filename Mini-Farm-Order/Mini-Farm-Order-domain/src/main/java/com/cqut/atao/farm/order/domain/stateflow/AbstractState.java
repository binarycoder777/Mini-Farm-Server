package com.cqut.atao.farm.order.domain.stateflow;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName BaseState.java
 * @Description 订单状态抽象类
 * @createTime 2023年02月17日 14:33:00
 */
public abstract class AbstractState {

    @Resource
    protected OrderRepository orderRepository;

    public abstract boolean pay(Long orderId,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean sendProduct(Long orderId,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean signProduct(Long orderId,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean commentProduct(Long orderId,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean returnProduct(Long orderId,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean returnMoney(Long orderId,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean finsh(Long orderId,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean cancelOrder(Long orderId,Enum<Constants.OrderState> currentOrderState);
}
