package com.cqut.atao.farm.order.domain.service;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

import java.util.List;

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
     *
     * @param order {@link Order}
     */
    void createOrder(Order order);

    /**
     * 创建父订单(不含具体商品列表信息)
     *
     * @param order {@link Order}
     */
    void createParentOrder(Order order);

    /**
     * 支付订单
     *
     * @param req 订单请求
     */
    void payOrder(AlterOrderStateReq req);

    /**
     * 取消订单
     *
     * @param req 订单请求
     */
    void cancelOrder(AlterOrderStateReq req);

    /**
     * 获取父订单id下的所有订单
     *
     * @param parentOrderId 父订单id
     * @return {@link List}
     */
    List<Order> getSubOrder(String parentOrderId);

    /**
     * 根据订单id查找订单
     *
     * @param orderId 订单id
     * @return {@link Order}
     */
    Order getOrderByOrderId(String orderId);

    /**
     * 查询订单分页信息
     *
     * @param req 分页请求
     * @return 分页结果
     */
    PageResponse<Order> queryOrderPageInfo(OrderPageReq req);

    /**
     * 提醒商家发货订单
     *
     * @param orderSn 订单号
     */
    void remindOrderDelivery(String orderSn);

    /**
     * 获取订单信息
     * @param orderSn
     * @return
     */
    Order getOrder(String orderSn);

    /**
     * 确认收货
     * @param orderNo
     */
    void confirmOrder(String orderNo);

    PageResponse<Order> queryOrderPageInfoAdmin(OrderPageReq req);
}
