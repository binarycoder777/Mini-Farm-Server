package com.cqut.atao.farm.order.infrastructure.repository.status.strategy;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.infrastructure.dao.OrderDAO;
import com.cqut.atao.farm.order.infrastructure.dao.OrderItemDAO;
import com.cqut.atao.farm.order.infrastructure.po.OrderItemPO;
import com.cqut.atao.farm.order.infrastructure.po.OrderPO;
import com.cqut.atao.farm.order.infrastructure.repository.status.PageQueryOrderInfo;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AfterSalesOrder.java
 * @Description 查询售后订单(包括待退款)
 * @createTime 2023年04月04日 09:07:00
 */
@Component
public class AfterSalesOrder implements PageQueryOrderInfo {

    @Resource
    private OrderDAO orderDAO;

    @Resource
    private OrderItemDAO orderItemDAO;

    @Override
    public PageResponse<Order> queryOrderPageInfo(OrderPageReq req) {
        int nums = 0;
        List<OrderPO> subOrders = Lists.newArrayList();
        // 查询待退款子订单
        req.setOrderStatus(Constants.OrderState.PEND_REFUND.getCode());
        List<OrderPO> pendRefundSubOrders = orderDAO.pageSubOrder(req);
        nums += orderDAO.countSubOrder(req.getOrderStatus());
        subOrders.addAll(pendRefundSubOrders);
        // 查询售后中子订单
        req.setOrderStatus(Constants.OrderState.AFTER_SALE.getCode());
        List<OrderPO> afterSaleSubOrders = orderDAO.pageSubOrder(req);
        nums += orderDAO.countSubOrder(req.getOrderStatus());
        subOrders.addAll(afterSaleSubOrders);
        // 查询订单商品详情
        subOrders.forEach(o -> {
            List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class)
                    .eq(OrderItemPO::getOrderSn, o.getOrderSn()));
            o.setOrderProducts(orderItemPOS);
        });
        Page<OrderPO> orderPOPage = new Page<>(req.getCurrent(), req.getSize(), nums);
        orderPOPage.setRecords(subOrders);
        return PageUtil.convert(orderPOPage, Order.class);
    }
}
