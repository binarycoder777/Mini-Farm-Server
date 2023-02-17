package com.cqut.atao.farm.order.domain.stateflow.state;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.stateflow.AbstractState;


/**
 * @author atao
 * @version 1.0.0
 * @ClassName PendRefundState.java
 * @Description 待退款状态
 * @createTime 2023年02月17日 22:03:00
 */
public class PendRefundState extends AbstractState {


    @Override
    public boolean pay(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean sendProduct(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean signProduct(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean commentProduct(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean returnProduct(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean returnMoney(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return orderRepository.alterState(orderId,currentOrderState, Constants.OrderState.TRADING_CLOSED);
    }

    @Override
    public boolean finsh(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean cancelOrder(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }
}
