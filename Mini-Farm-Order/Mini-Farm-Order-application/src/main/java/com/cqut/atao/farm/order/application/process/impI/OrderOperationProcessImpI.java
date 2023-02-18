package com.cqut.atao.farm.order.application.process.impI;

import com.cqut.atao.farm.order.application.process.AbstractOrderOperation;
import com.cqut.atao.farm.order.application.process.OrderOperationProcess;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.remote.RemoteCartService;
import com.cqut.atao.farm.order.domain.remote.model.req.DeleteCartItemReq;
import com.cqut.atao.farm.order.domain.service.OrderService;
import io.prometheus.client.Collector;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateOrderProcessImpI.java
 * @Description 创建订单实流程现类
 * @createTime 2023年02月04日 16:05:00
 */
public class OrderOperationProcessImpI extends AbstractOrderOperation {



    @Override
    protected String generateOrder(Order order) {
        // 暂时用uuid生产订单号
        String uuid = UUID.randomUUID().toString();
        order.setOrderSn(uuid);
        orderService.createOrder(order);
        return uuid;
    }


    @Override
    public void cancelOrder(String orderNo) {
        // 1.修改订单信息

        // 2.删除订单商品详情信息

        // 3.释放锁定商品库存
    }
}
