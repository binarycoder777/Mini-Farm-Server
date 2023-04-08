package com.cqut.atao.farm.order.application.process.impI;

import cn.hutool.core.lang.Assert;
import com.cqut.atao.farm.order.application.process.AbstractOrderOperation;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.domain.mq.produce.MessageProduce;
import com.cqut.atao.farm.order.domain.remote.model.req.OrderInfoReq;
import com.cqut.atao.farm.order.domain.remote.model.req.OrderItemInfo;
import com.cqut.atao.farm.rocketmq.springboot.starter.event.ReturnSpecialMessageSendEvent;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateOrderProcessImpI.java
 * @Description 创建订单实流程现类
 * @createTime 2023年02月04日 16:05:00
 */
@Service
public class OrderOperationProcessImpI extends AbstractOrderOperation {

    @Resource
    private MessageProduce messageProduce;

    @Override
    protected String saveOrder(Order order) {
        // 保存父订单
        orderService.createParentOrder(order);
        // 父订单拆分（父订单含汇总信息，子订单包含详细信息）
        List<Order> orders = orderSplitHandler.splitOrder(order);
        for (Order subOrder : orders) {
            // 锁定库存
            Assert.isTrue(this.lockStock(subOrder), () -> new ServiceException("商品库存异常"));
            // 保存子订单
            orderService.createOrder(subOrder);
        }
        // 返回父订单号
        return order.getOrderSn();
    }


    @Override
    public void cancelOrder(String parentOrderId) {
        // 获取该订单下的订单集合
        List<Order> orderList = orderService.getSubOrder(parentOrderId);
        // 订单状态流转为取消状态
        orderList.forEach(e -> {
            AlterOrderStateReq req = AlterOrderStateReq.builder()
                    .orderSn(e.getOrderSn())
                    .currentSate(Constants.OrderState.getStateByCode(e.getStatus()))
                    .build();
            orderService.cancelOrder(req);
        });
        // 远程调用商品服务释放锁定商品库存
        List<OrderItemInfo> list = new ArrayList<>();
        orderList.forEach(e -> {
            List<OrderProduct> orderProducts = e.getOrderProducts();
            orderProducts.forEach(p -> {
                OrderItemInfo orderItemInfo = OrderItemInfo.builder()
                        .skuId(p.getProductSkuId())
                        .num(p.getProductQuantity())
                        .build();
                list.add(orderItemInfo);
            });
        });
        OrderInfoReq orderInfoReq = OrderInfoReq.builder()
                .orderItemInfos(list)
                .build();
        remoteProductService.unlockProductStock(orderInfoReq);
        // MQ异步返还用户的优惠信息
        Order order = orderService.getOrderByOrderId(parentOrderId);
        if (order.getCouponId() != null || order.getSpecialActivityId() != null) {
            ReturnSpecialMessageSendEvent returnSpecialMessageSendEvent = ReturnSpecialMessageSendEvent.builder()
                    .messageSendId(UUID.randomUUID().toString())
                    .acitivityId(order.getSpecialActivityId())
                    .couponId(order.getCouponId())
                    .build();
            messageProduce.returnSpecialMessageSend(returnSpecialMessageSendEvent);
        }
    }

    /**
     * 分页查询订单
     *
     * @param req 分页请求
     * @return 分页结果
     */
    public PageResponse<Order> pageQueryOrder(OrderPageReq req) {
        return orderService.queryOrderPageInfo(req);
    }

    /**
     * 提醒商家发货订单
     *
     * @param orderSn
     */
    public void remindOrder(String orderSn) {
        orderService.remindOrderDelivery(orderSn);
    }

    /**
     * 查询订单信息
     * @param orderSn
     * @return
     */
    public Order getOrderInfo(String orderSn) {
        return orderService.getOrder(orderSn);
    }

    /**
     * 确认收货
     * @param orderNo
     */
    public void confirmOrder(String orderNo) {
        orderService.confirmOrder(orderNo);
    }

}
