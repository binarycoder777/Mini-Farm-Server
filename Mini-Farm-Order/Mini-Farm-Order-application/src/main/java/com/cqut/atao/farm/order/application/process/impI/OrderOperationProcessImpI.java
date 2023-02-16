package com.cqut.atao.farm.order.application.process.impI;

import com.cqut.atao.farm.order.application.process.OrderOperationProcess;
import com.cqut.atao.farm.order.application.process.req.CreateOrderReq;
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

    public String createOrder(CreateOrderReq req) {
        // 1.生成订单号

        // 2.远程调用购物车服务，获取已选中的结算商品列表

        // 3.构建订单聚合对象

        // 4.创建订单

        // 5.清空购物车已选中商品列表

        // 6.锁定商品库存

        // 发送消给延迟队列(取消未支付的订单)
        return null;
    }


    public void cancelOrder(String orderNo) {
        // 1.修改订单信息

        // 2.删除订单商品详情信息

        // 3.释放锁定商品库存
    }
}
