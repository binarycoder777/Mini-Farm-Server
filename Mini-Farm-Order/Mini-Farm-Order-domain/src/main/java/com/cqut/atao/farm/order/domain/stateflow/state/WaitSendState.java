package com.cqut.atao.farm.order.domain.stateflow.state;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.stateflow.AbstractState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ObligationState.java
 * @Description 待发货状态
 * @createTime 2023年02月17日 14:30:00
 */
@Slf4j
@Component
public class WaitSendState extends AbstractState {


    @Override
    public boolean pay(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
    }

    @Override
    public boolean sendProduct(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return orderRepository.alterState(orderId,currentOrderState, Constants.OrderState.WAIT_SIGNATURE);
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
        return orderRepository.alterState(orderId,currentOrderState, Constants.OrderState.PEND_REFUND);
    }

    @Override
    public boolean returnMoney(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return false;
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
