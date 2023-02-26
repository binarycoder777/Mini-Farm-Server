package com.cqut.atao.farm.order.application.process.impI;

import com.cqut.atao.farm.order.application.process.AbstractOrderOperation;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
