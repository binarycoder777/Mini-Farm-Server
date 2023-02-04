package com.cqut.atao.farm.order.domain.service.impI;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import com.cqut.atao.farm.order.domain.service.OrderService;
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
    private OrderRepository orderRepository;


    public void createOrder(Order order) {
        // 保存订单
        orderRepository.saveOrder(order);
        // 保存订单商品详情
        orderRepository.saveOrderItem(order);
    }
}
