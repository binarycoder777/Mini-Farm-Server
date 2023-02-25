package com.cqut.atao.farm.order.domain.listener;

import com.cqut.atao.farm.order.domain.event.CancelOrderEvent;
import com.cqut.atao.farm.order.domain.event.CreateOrderEvent;
import com.cqut.atao.farm.order.domain.event.PayEvent;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;

import com.cqut.atao.farm.order.domain.stateflow.StateHandler;
import org.springframework.context.event.EventListener;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderEventListener.java
 * @Description 订单事件监听器
 * @createTime 2023年02月17日 14:28:00
 */
public class OrderEventListener {

    @Resource
    private StateHandler stateHandler;

    @Resource
    private OrderRepository orderRepository;

    @EventListener(CreateOrderEvent.class)
    public void pay(CreateOrderEvent event){
        Order order = (Order) event.getSource();
        orderRepository.saveOrder(order);
    }

    @EventListener(PayEvent.class)
    public void pay(PayEvent event){
        AlterOrderStateReq source = (AlterOrderStateReq) event.getSource();
        stateHandler.pay(source.getOrderSn(),source.getCurrentSate());
    }

    @EventListener(PayEvent.class)
    public void cancelOrder(CancelOrderEvent event){
        AlterOrderStateReq source = (AlterOrderStateReq) event.getSource();
        stateHandler.pay(source.getOrderSn(),source.getCurrentSate());
    }

}
