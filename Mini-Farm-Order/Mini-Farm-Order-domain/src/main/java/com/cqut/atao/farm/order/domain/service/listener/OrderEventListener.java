package com.cqut.atao.farm.order.domain.service.listener;


import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;
import com.cqut.atao.farm.order.domain.remote.RemoteUserService;
import com.cqut.atao.farm.order.domain.remote.model.res.UserInfoRes;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import com.cqut.atao.farm.order.domain.service.event.*;
import com.cqut.atao.farm.order.domain.stateflow.StateHandler;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderEventListener.java
 * @Description 订单事件监听器
 * @createTime 2023年02月17日 14:28:00
 */
@Slf4j
@Component
public class OrderEventListener {

    @Resource
    private StateHandler stateHandler;

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private RemoteUserService remoteUserService;

    @EventListener(CreateOrderEvent.class)
    public void createSubOrder(CreateOrderEvent event){
        Order order = (Order) event.getSource();
        orderRepository.saveOrder(order);
    }

    @EventListener(CreateParentOrderEvent.class)
    public void createParentOrder(CreateParentOrderEvent event){
        Order order = (Order) event.getSource();
        orderRepository.saveParentOrder(order);
    }

    @EventListener(PayEvent.class)
    public void pay(PayEvent event){
        AlterOrderStateReq source = (AlterOrderStateReq) event.getSource();
        stateHandler.pay(source.getOrderSn(),source.getCurrentSate());
    }

    @EventListener(CancelOrderEvent.class)
    public void cancelOrder(CancelOrderEvent event){
        AlterOrderStateReq source = (AlterOrderStateReq) event.getSource();
        stateHandler.cancelOrder(source.getOrderSn(),source.getCurrentSate());
    }


    @EventListener(RemindDeliveryEvent.class)
    public void remindOrder(RemindDeliveryEvent event){
        // 订单号
        String orderSn = (String) event.getSource();
        // 查询订单对应商家
        Long merchantId = orderRepository.queryMerchantId(orderSn);
//        Result<UserInfoRes> result = remoteUserService.getUserInfoByUserId(merchantId);
        // 调用消息服务发送提醒发货消息给对应商家
        log.warn("提醒商家发货:{}",merchantId);
    }


}
