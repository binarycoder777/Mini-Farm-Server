package com.cqut.atao.farm.order.domain.service.impI;


import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterAddressReq;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.domain.model.req.SendProductReq;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import com.cqut.atao.farm.order.domain.service.OrderService;
import com.cqut.atao.farm.order.domain.service.event.*;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
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

    @Override
    public PageResponse<Order> queryOrderPageInfo(OrderPageReq req) {
        return orderRepository.queryOrderPageInfo(req);
    }

    @Override
    public void remindOrderDelivery(String orderSn) {
        eventPublisher.publishEvent(new RemindDeliveryEvent(orderSn));
    }

    @Override
    public Order getOrder(String orderSn) {
        return orderRepository.queryOrderInfo(orderSn);
    }

    @Override
    public void confirmOrder(String orderNo) {
        eventPublisher.publishEvent(new ConfirmOrderEvent(orderNo));
    }

    @Override
    public PageResponse<Order> queryOrderPageInfoAdmin(OrderPageReq req) {
        return orderRepository.queryOrderPageInfoAdmin(req);
    }

    @Override
    public void orderDelivery(SendProductReq req) {
        orderRepository.orderDelivery(req);
    }

    @Override
    public void updateOrderAddress(AlterAddressReq req) {
        eventPublisher.publishEvent(new UpdateAddressEvent(req));
    }
}
