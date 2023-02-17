package com.cqut.atao.farm.order.domain.service.stateflow;

import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

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

    public abstract boolean pay(Long orderId,Enum<Constants.OrderState> currentOrderState);

}
