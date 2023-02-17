package com.cqut.atao.farm.order.domain.service.impI;

import com.cqut.atao.farm.order.domain.event.CancelOrderEvent;
import com.cqut.atao.farm.order.domain.event.CreateOrderEvent;
import com.cqut.atao.farm.order.domain.event.PayEvent;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;
import com.cqut.atao.farm.order.domain.service.OrderService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    private ApplicationEventPublisher eventPublisher;

    public void createOrder(Order order) {
        eventPublisher.publishEvent(new CreateOrderEvent(order));
    }

    public void payOrder(AlterOrderStateReq req) {
        eventPublisher.publishEvent(new PayEvent(req));
    }

    public void cancelOrder(AlterOrderStateReq req) {
        eventPublisher.publishEvent(new CancelOrderEvent(req));
    }
}
