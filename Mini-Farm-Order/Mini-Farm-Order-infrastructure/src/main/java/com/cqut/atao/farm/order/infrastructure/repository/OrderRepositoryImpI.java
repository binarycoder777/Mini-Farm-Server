package com.cqut.atao.farm.order.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import com.cqut.atao.farm.order.infrastructure.dao.OrderDAO;
import com.cqut.atao.farm.order.infrastructure.dao.OrderItemDAO;
import com.cqut.atao.farm.order.infrastructure.po.OrderItemPO;
import com.cqut.atao.farm.order.infrastructure.po.OrderPO;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderRepositoryImpI.java
 * @Description 订单仓储层实现类
 * @createTime 2023年02月04日 16:58:00
 */
@Repository
public class OrderRepositoryImpI implements OrderRepository {

    @Resource
    private OrderDAO orderDAO;

    @Resource
    private OrderItemDAO orderItemDAO;

    @Override
    public void saveOrder(Order order) {
        OrderPO orderPO = BeanUtil.convert(order, OrderPO.class);
        int res = orderDAO.insert(orderPO);
        Assert.isTrue(res > 0 , ()->new ServiceException("保存订单异常"));
    }

    @Override
    public void saveOrderItem(Order order) {
        List<OrderItemPO> orderItemPOS = BeanUtil.convert(order.getOrderProducts(), OrderItemPO.class);
        for (OrderItemPO itemPO: orderItemPOS) {
            int res = orderItemDAO.insert(itemPO);
            Assert.isTrue(res > 0 , ()->new ServiceException("保存订单异常"));
        }
    }
}
