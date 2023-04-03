package com.cqut.atao.farm.order.application.process;


import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.domain.model.req.PlaceOrderReq;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateOrder.java
 * @Description 创建订单流程接口
 * @createTime 2023年02月04日 15:32:00
 */
public interface OrderOperationProcess {


    /**
     * 创建订单
     * @param req {@link PlaceOrderReq}
     * @return 订单号
     */
    String createOrder(PlaceOrderReq req);

    /**
     * 取消订单
     * @param orderId 订单id
     */
    void cancelOrder(String orderId);

}
