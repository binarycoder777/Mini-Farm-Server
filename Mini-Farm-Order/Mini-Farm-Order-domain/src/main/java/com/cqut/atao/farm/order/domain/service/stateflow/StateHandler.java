package com.cqut.atao.farm.order.domain.service.stateflow;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName StateHandler.java
 * @Description 状态处理器
 * @createTime 2023年02月17日 14:31:00
 */
public interface StateHandler {


    boolean pay(Long orderId,Enum<Constants.OrderState> currentOrderState);

}
