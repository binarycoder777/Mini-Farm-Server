package com.cqut.atao.farm.order.domain.stateflow;

import com.cqut.atao.farm.order.domain.common.Constants;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName StateHandler.java
 * @Description 状态处理器
 * @createTime 2023年02月17日 14:31:00
 */
public interface StateHandler {


    public abstract boolean pay(Long orderId, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean sendProduct(Long orderId, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean signProduct(Long orderId, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean commentProduct(Long orderId, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean returnProduct(Long orderId, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean returnMoney(Long orderId, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean finsh(Long orderId, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean cancelOrder(Long orderId, Enum<Constants.OrderState> currentOrderState);
}
