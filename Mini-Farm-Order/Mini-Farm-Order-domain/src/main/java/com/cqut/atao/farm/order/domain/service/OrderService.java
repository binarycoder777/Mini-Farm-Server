package com.cqut.atao.farm.order.domain.service;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrederService.java
 * @Description 订单服务接口
 * @createTime 2023年02月04日 15:39:00
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order {@link Order}
     */
    void createOrder(Order order);

    /**
     * 支付订单
     * @param req 订单请求
     */
    void payOrder(AlterOrderStateReq req);

}
