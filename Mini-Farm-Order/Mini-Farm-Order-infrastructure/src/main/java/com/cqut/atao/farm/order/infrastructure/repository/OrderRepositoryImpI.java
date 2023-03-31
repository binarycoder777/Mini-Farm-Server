package com.cqut.atao.farm.order.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import com.cqut.atao.farm.order.infrastructure.dao.OrderDAO;
import com.cqut.atao.farm.order.infrastructure.dao.OrderItemDAO;
import com.cqut.atao.farm.order.infrastructure.po.OrderItemPO;
import com.cqut.atao.farm.order.infrastructure.po.OrderPO;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderRepositoryImpI.java
 * @Description 订单仓储层实现类
 * @createTime 2023年02月04日 16:58:00
 */
@Slf4j
@Repository
public class OrderRepositoryImpI implements OrderRepository {

    @Resource
    private OrderDAO orderDAO;

    @Resource
    private OrderItemDAO orderItemDAO;

    @Override
    public void saveOrder(Order order) {
        // 订单基本信息
        OrderPO orderPO = BeanUtil.convert(order, OrderPO.class);
        int res0 = orderDAO.insert(orderPO);
        Assert.isTrue(res0 > 0, () -> new ServiceException("保存订单异常"));
        // 订单商品详情
        List<OrderItemPO> orderItemPOS = BeanUtil.convert(order.getOrderProducts(), OrderItemPO.class);
        for (OrderItemPO itemPO : orderItemPOS) {
            int res1 = orderItemDAO.insert(itemPO);
            Assert.isTrue(res1 > 0, () -> new ServiceException("保存订单异常"));
        }
    }

    @Override
    public void saveParentOrder(Order order) {
        // 订单基本信息
        OrderPO orderPO = BeanUtil.convert(order, OrderPO.class);
        int res0 = orderDAO.insert(orderPO);
        Assert.isTrue(res0 > 0, () -> new ServiceException("保存订单异常"));
    }

    @Override
    public boolean alterState(String orderId, Enum<Constants.OrderState> currentState, Enum<Constants.OrderState> nextState) {
        return orderDAO.alterOrderState(orderId, currentState, nextState) > 0;
    }

    @Override
    public List<Order> getSubOrder(String parentOrderId) {
        List<OrderPO> orderPOS = orderDAO.selectList(Wrappers.lambdaQuery(OrderPO.class).eq(OrderPO::getParentId, parentOrderId));
        orderPOS.forEach(e -> {
            List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class).eq(OrderItemPO::getOrderId, e.getId()));
            e.setOrderProducts(orderItemPOS);
        });
        return BeanUtil.convert(orderPOS, Order.class);
    }

    @Override
    public Order selectOrderByOrderId(String orderId) {
        return BeanUtil.convert(orderDAO.selectById(orderId), Order.class);
    }

    @Override
    public PageResponse<Order> queryOrderPageInfo(OrderPageReq req) {
        // 如果是未支付订单，此时回显的应该是以父订单为主
        if (Constants.OrderState.OBLIGATEION.getCode().equals(req.getOrderStatus())) {
            // 查询父订单
            List<OrderPO> parentOrders = orderDAO.pageParentOrder(req);
            // 遍历父订单
            parentOrders.forEach(o->{
                // 查询父订单的子订单
                List<OrderPO> subOrders = orderDAO.listSubOrder(req.getUserId(),o.getParentId(),req.getOrderStatus());
                List<OrderItemPO> orderProductList = Lists.newArrayList();
                // 查询子订单对应的商品详情
                subOrders.forEach(e->{
                    List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class)
                            .eq(OrderItemPO::getOrderSn, e.getOrderSn()));
                    orderProductList.addAll(orderItemPOS);
                });
                o.setOrderProducts(orderProductList);
            });
            // 查询数量
            int nums = orderDAO.countParentOrder(req.getOrderStatus());
            Page<OrderPO> orderPOPage = new Page<>(req.getCurrent(),req.getSize(),nums);
            orderPOPage.setRecords(parentOrders);
            return PageUtil.convert(orderPOPage,Order.class);
        }

        // 查询子订单
         List<OrderPO> subOrders = orderDAO.pageSubOrder(req);
        // 查询订单商品详情
        subOrders.forEach(o->{
             List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class)
                    .eq(OrderItemPO::getOrderSn, o.getOrderSn()));
             o.setOrderProducts(orderItemPOS);
        });
        // 查询数量
        int nums = orderDAO.countSubOrder(req.getOrderStatus());
        Page<OrderPO> orderPOPage = new Page<>(req.getCurrent(),req.getSize(),nums);
        orderPOPage.setRecords(subOrders);
        return PageUtil.convert(orderPOPage,Order.class);
    }
}
