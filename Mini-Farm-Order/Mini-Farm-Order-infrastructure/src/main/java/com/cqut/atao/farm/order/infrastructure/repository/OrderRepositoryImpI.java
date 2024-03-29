package com.cqut.atao.farm.order.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import com.cqut.atao.farm.order.domain.model.req.AlterAddressReq;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.domain.model.req.SendProductReq;
import com.cqut.atao.farm.order.domain.model.res.OrderSalesVolume;
import com.cqut.atao.farm.order.domain.model.res.PendingTransactions;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import com.cqut.atao.farm.order.infrastructure.dao.OrderDAO;
import com.cqut.atao.farm.order.infrastructure.dao.OrderItemDAO;
import com.cqut.atao.farm.order.infrastructure.dao.OrderReturnApplyDAO;
import com.cqut.atao.farm.order.infrastructure.po.OrderItemPO;
import com.cqut.atao.farm.order.infrastructure.po.OrderPO;
import com.cqut.atao.farm.order.infrastructure.repository.status.OrderStatusContent;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

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

    @Resource
    private OrderStatusContent orderStatusContent;

    @Resource
    private OrderReturnApplyDAO orderReturnApplyDAO;

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
        return orderDAO.alterOrderState(orderId, Constants.OrderState.getCodeByConstans(currentState), Constants.OrderState.getCodeByConstans(nextState)) > 0;
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
        PageResponse<Order> response = orderStatusContent.maps.get(Constants.FrontOrderState.getStateByCode(req.getFrontOrderStatus()))
                .queryOrderPageInfo(req);
        return response;
    }

    @Override
    public Long queryMerchantId(String orderSn) {
        // 同一子订单下商家一定相同
        OrderItemPO itemPO = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class)
                .eq(OrderItemPO::getOrderSn, orderSn)).get(0);
        return itemPO.getMerchantId();
    }

    @Override
    public Order queryOrderInfo(String orderSn) {
        // 查询父订单
        OrderPO parentOrder = orderDAO.parentOrder(orderSn);
        if (parentOrder != null) {
            // 查询父订单的子订单
            List<OrderPO> subOrders = orderDAO.subOrderList(parentOrder.getParentId());
            List<OrderItemPO> orderProductList = Lists.newArrayList();
            // 查询子订单对应的商品详情
            subOrders.forEach(e -> {
                List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class)
                        .eq(OrderItemPO::getOrderSn, e.getOrderSn()));
                orderProductList.addAll(orderItemPOS);
            });
            parentOrder.setOrderProducts(orderProductList);
            return BeanUtil.convert(parentOrder,Order.class);
        } else  {
            // 是子订单
            OrderPO orderPO = orderDAO.selectOne(Wrappers.lambdaQuery(OrderPO.class).eq(OrderPO::getOrderSn, orderSn));
            List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class)
                    .eq(OrderItemPO::getOrderSn, orderPO.getOrderSn()));
            orderPO.setOrderProducts(orderItemPOS);
            return BeanUtil.convert(orderPO,Order.class);
        }
    }

    @Override
    public PageResponse<Order> queryOrderPageInfoAdmin(OrderPageReq req) {
        PageResponse<Order> response = orderStatusContent.maps.get(Constants.FrontOrderState.getStateByCode(req.getFrontOrderStatus()))
                .queryOrderPageInfo(req);
        return response;
    }

    @Override
    public void orderDelivery(SendProductReq req) {
        req.setStatus(Constants.OrderState.getCodeByConstans(Constants.OrderState.WAIT_SIGNATURE));
        orderDAO.update(BeanUtil.convert(req,OrderPO.class),
                Wrappers.lambdaUpdate(OrderPO.class).eq(OrderPO::getOrderSn,req.getOrderSn()));
    }

    @Override
    public void updateOrder(AlterAddressReq req) {
        orderDAO.update(BeanUtil.convert(req,OrderPO.class),
                Wrappers.lambdaUpdate(OrderPO.class).eq(OrderPO::getOrderSn,req.getOrderSn()));
    }

    @Override
    public OrderSalesVolume orderSalesVolumeStatistics(Date current) {
        // 当前时间+1天
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(current);
        calendar.add(Calendar.DATE, 1);
        Date end = calendar.getTime();
        // 数量
        int num = orderDAO.countOrderSales(current,end);
        // 金额
        BigDecimal sum = orderDAO.sumOrderSales(current,end);
        // 结果
        return OrderSalesVolume.builder()
                .orderAmount(sum)
                .orderCount(num)
                .date(current)
                .build();
    }

    @Override
    public PendingTransactions pendingTransactions() {
        return PendingTransactions.builder()
                .sendProduct(orderDAO.waitSigneOrder())
                .waitConfirmRecive(orderReturnApplyDAO.waitConfirmRefundOrder())
                .waitPay(orderDAO.waitPayOrder())
                .waitRefundMoney(orderReturnApplyDAO.waitConfirmRefundOrder())
                .waitReturnProduct(orderReturnApplyDAO.waitConfirmReturnOrder())
                .waitSendProduct(orderDAO.waitSendOrder())
                .build();
    }

    @Override
    public OrderSalesVolume sales(Date one, Date date) {
        // 数量
        int num = orderDAO.countOrderSales(one,date);
        // 金额
        BigDecimal sum = orderDAO.sumOrderSales(one,date);
        // 结果
        return OrderSalesVolume.builder()
                .orderAmount(sum)
                .orderCount(num)
                .date(one)
                .build();
    }
}
