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


    public abstract boolean pay(String orderSn, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean sendProduct(String orderSn, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean signProduct(String orderSn, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean commentProduct(String orderSn, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean returnProduct(String orderSn, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean returnMoney(String orderSn, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean finsh(String orderSn, Enum<Constants.OrderState> currentOrderState);

    public abstract boolean cancelOrder(String orderSn, Enum<Constants.OrderState> currentOrderState);
}
