package com.cqut.atao.farm.order.domain.service.stateflow.state;

import com.cqut.atao.farm.order.domain.service.stateflow.AbstractState;
import com.cqut.atao.farm.order.domain.service.stateflow.Constants;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ObligationState.java
 * @Description 待付款状态
 * @createTime 2023年02月17日 14:30:00
 */
@Component
public class ObligationState extends AbstractState {


    @Override
    public boolean pay(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return orderRepository.alterState(orderId,currentOrderState,Constants.OrderState.WAIT_SEND);
    }
}
