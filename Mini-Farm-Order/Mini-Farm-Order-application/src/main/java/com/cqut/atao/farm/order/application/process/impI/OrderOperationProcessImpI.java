package com.cqut.atao.farm.order.application.process.impI;

import com.cqut.atao.farm.order.application.process.OrderOperationProcess;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.service.OrderService;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateOrderProcessImpI.java
 * @Description 创建订单实流程现类
 * @createTime 2023年02月04日 16:05:00
 */
public class OrderOperationProcessImpI implements OrderOperationProcess {

    @Resource
    private OrderService orderService;

    public String createOrder(Order order) {
        // 核算金额

        // 锁定库存

        // 创建订单

        // 清空购物车已选中商品列表

        // 发送消给延迟队列(取消未支付的订单)
        return null;
    }


    public void cancelOrder(String orderNo) {
        // 1.修改订单信息

        // 2.删除订单商品详情信息

        // 3.释放锁定商品库存
    }
}
