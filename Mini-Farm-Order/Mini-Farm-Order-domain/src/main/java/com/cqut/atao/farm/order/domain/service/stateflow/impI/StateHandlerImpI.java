package com.cqut.atao.farm.order.domain.service.stateflow.impI;

import com.cqut.atao.farm.order.domain.service.stateflow.Constants;
import com.cqut.atao.farm.order.domain.service.stateflow.StateConfig;
import com.cqut.atao.farm.order.domain.service.stateflow.StateHandler;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName StateHandlerImpI.java
 * @Description 状态处理器实现类
 * @createTime 2023年02月17日 14:46:00
 */
public class StateHandlerImpI extends StateConfig implements StateHandler {

    public boolean pay(Long orderId, Enum<Constants.OrderState> currentOrderState) {
        return stateMap.get(currentOrderState).pay(orderId,currentOrderState);
    }
}
