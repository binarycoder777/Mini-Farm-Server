package com.cqut.atao.farm.order.domain.stateflow.state;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.stateflow.AbstractState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ObligationState.java
 * @Description 售后状态
 * @createTime 2023年02月17日 14:30:00
 */
@Slf4j
@Component
public class AfterSaleState extends AbstractState {


    @Override
    public boolean pay(String orderSn, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean sendProduct(String orderSn, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean signProduct(String orderSn, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean commentProduct(String orderSn, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean returnProduct(String orderSn, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean returnMoney(String orderSn, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean finsh(String orderSn, Enum<Constants.OrderState> currentOrderState) {
        return orderRepository.alterState(orderSn,currentOrderState, Constants.OrderState.TRADING_CLOSED);
    }

    @Override
    public boolean cancelOrder(String orderSn, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }
}
