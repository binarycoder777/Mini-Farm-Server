package com.cqut.atao.farm.order.domain.service.impI;


import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import com.cqut.atao.farm.order.domain.service.OrderService;
import com.cqut.atao.farm.order.domain.service.event.CancelOrderEvent;
import com.cqut.atao.farm.order.domain.service.event.CreateOrderEvent;
import com.cqut.atao.farm.order.domain.service.event.CreateParentOrderEvent;
import com.cqut.atao.farm.order.domain.service.event.PayEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderServiceImpI.java
 * @Description 订单服务实现类
 * @createTime 2023年02月04日 16:58:00
 */
@Service
public class OrderServiceImpI implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void createOrder(Order order) {
        eventPublisher.publishEvent(new CreateOrderEvent(order));
    }

    @Override
    public void payOrder(AlterOrderStateReq req) {
        eventPublisher.publishEvent(new PayEvent(req));
    }

    @Override
    public void cancelOrder(AlterOrderStateReq req) {
        eventPublisher.publishEvent(new CancelOrderEvent(req));
    }

    @Override
    public List<Order> getSubOrder(String parentOrderId) {
        return orderRepository.getSubOrder(parentOrderId);
    }

    @Override
    public Order getOrderByOrderId(String orderId) {
        return orderRepository.selectOrderByOrderId(orderId);
    }

    @Override
    public void createParentOrder(Order order) {
        eventPublisher.publishEvent(new CreateParentOrderEvent(order));
    }
}
