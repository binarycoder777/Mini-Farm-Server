package com.cqut.atao.farm.order.application.process.impI;

import cn.hutool.core.lang.Assert;
import com.cqut.atao.farm.order.application.process.AbstractOrderOperation;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateOrderProcessImpI.java
 * @Description 创建订单实流程现类
 * @createTime 2023年02月04日 16:05:00
 */
@Service
public class OrderOperationProcessImpI extends AbstractOrderOperation {

    @Override
    protected String saveOrder(Order order) {
        // 保存父订单
        orderService.createOrder(order);
        // 父订单拆分（父订单含汇总信息，子订单包含详细信息）
        List<Order> orders = orderSplitHandler.splitOrder(order);
        for (Order subOrder: orders) {
            // 锁定库存
            Assert.isTrue(this.lockStock(subOrder) , ()->new ServiceException("商品库存异常"));
            // 保存子订单
            orderService.createOrder(subOrder);
        }
        // 返回父订单号
        return order.getOrderSn();
    }


    @Override
    public void cancelOrder(String orderNo) {
        // 1.修改订单信息

        // 2.删除订单商品详情信息

        // 3.释放锁定商品库存
    }
}
