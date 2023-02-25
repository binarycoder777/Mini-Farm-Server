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

    public abstract boolean pay(String orderSn,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean sendProduct(String orderSn,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean signProduct(String orderSn,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean commentProduct(String orderSn,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean returnProduct(String orderSn,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean returnMoney(String orderSn,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean finsh(String orderSn,Enum<Constants.OrderState> currentOrderState);

    public abstract boolean cancelOrder(String orderSn,Enum<Constants.OrderState> currentOrderState);
}
