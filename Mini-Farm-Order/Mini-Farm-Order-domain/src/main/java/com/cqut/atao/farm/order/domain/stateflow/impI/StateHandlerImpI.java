package com.cqut.atao.farm.order.domain.stateflow.impI;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.stateflow.StateConfig;
import com.cqut.atao.farm.order.domain.stateflow.StateHandler;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName StateHandlerImpI.java
 * @Description 状态处理器实现类
 * @createTime 2023年02月17日 14:46:00
 */
public class StateHandlerImpI extends StateConfig implements StateHandler {

    public boolean pay(String orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).pay(orderId,currentOrderState);
    }

    public boolean sendProduct(String orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).sendProduct(orderId,currentOrderState);
    }

    public boolean signProduct(String orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).signProduct(orderId,currentOrderState);
    }

    public boolean commentProduct(String orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).commentProduct(orderId,currentOrderState);
    }

    public boolean returnProduct(String orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).returnProduct(orderId,currentOrderState);
    }

    public boolean returnMoney(String orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).returnMoney(orderId,currentOrderState);
    }

    public boolean finsh(String orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).finsh(orderId,currentOrderState);
    }

    public boolean cancelOrder(String orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).cancelOrder(orderId,currentOrderState);
    }
}
