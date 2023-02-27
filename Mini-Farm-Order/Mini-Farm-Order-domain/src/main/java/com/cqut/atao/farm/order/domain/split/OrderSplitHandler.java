package com.cqut.atao.farm.order.domain.split;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.split.filter.MerchantFilter;
import com.cqut.atao.farm.order.domain.split.special.Caculator;
import com.cqut.atao.farm.order.domain.split.special.SpecialSplit;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderSplitHandler.java
 * @Description 订单拆分处理器
 * @createTime 2023年02月26日 23:34:00
 */
@Component
public class OrderSplitHandler implements OrderSplit{

    private OrderSplitAbstract splitOrder;

    @Resource
    private MerchantFilter merchantFilter;

    @Resource
    private SpecialSplit specialSplit;

    /**
     * 编排订单拆分顺序(按商家拆分->按类型拆分->按类目拆分->按仓库->分开发货)
     */
    @PostConstruct
    public void init(){
        // 目前先实现按商家拆分订单（后续增加其他）
        splitOrder = merchantFilter;
    }

    @Override
    public List<Order> splitOrder(Order order) {
        // 生成子订单(订单拆分)
        List<Order> orders = splitOrder.splitOrder(order);
        // 优惠分摊
        orders.forEach(e->{
            specialSplit.cacualte(e);
        });
        // 返回结果
        return orders;
    }


}
