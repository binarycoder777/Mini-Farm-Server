package com.cqut.atao.farm.order.infrastructure.repository.status.strategy;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.infrastructure.repository.status.PageQueryOrderInfo;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AllOrder.java
 * @Description 所有订单
 * @createTime 2023年04月04日 09:12:00
 */
@Slf4j
@Component
public class AllOrder implements PageQueryOrderInfo {

    @Resource
    private AfterSalesOrder afterSalesOrder;

    @Resource
    private NormalOrder normalOrder;

    @Resource
    private UnpiadOrder unpiadOrder;

    @Override
    public PageResponse<Order> queryOrderPageInfo(OrderPageReq req) {
        int num = 0;
        List<Order> list = Lists.newArrayList();
        // 售后订单
        PageResponse<Order> afterSales = afterSalesOrder.queryOrderPageInfo(req);
        list.addAll(afterSales.getRecords());
        num += afterSales.getTotal();
        // 未支付订单
        req.setOrderStatus(Constants.OrderState.OBLIGATEION.getCode());
        PageResponse<Order> unpaid = unpiadOrder.queryOrderPageInfo(req);
        list.addAll(unpaid.getRecords());
        num += unpaid.getTotal();
        // 待发货
        req.setOrderStatus(Constants.OrderState.WAIT_SEND.getCode());
        PageResponse<Order> back = normalOrder.queryOrderPageInfo(req);
        list.addAll(back.getRecords());
        num += back.getTotal();
        // 待签收
        req.setOrderStatus(Constants.OrderState.WAIT_SIGNATURE.getCode());
        PageResponse<Order> unrecive = normalOrder.queryOrderPageInfo(req);
        list.addAll(unrecive.getRecords());
        num += unrecive.getTotal();
        // 待评价
        req.setOrderStatus(Constants.OrderState.WAIT_COMMENT.getCode());
        PageResponse<Order> uncomment = normalOrder.queryOrderPageInfo(req);
        list.addAll(uncomment.getRecords());
        num += uncomment.getTotal();
        // 已完成
        req.setOrderStatus(Constants.OrderState.HAVE_COMMENT.getCode());
        PageResponse<Order> completed = normalOrder.queryOrderPageInfo(req);
        list.addAll(completed.getRecords());
        num += completed.getTotal();
        // 已取消
        req.setOrderStatus(Constants.OrderState.TRADING_CLOSED.getCode());
        PageResponse<Order> closed = normalOrder.queryOrderPageInfo(req);
        list.addAll(closed.getRecords());
        num += closed.getTotal();
        // 封装
        Page<Order> orderPage = new Page<>(req.getCurrent(), req.getSize(), num);
        orderPage.setRecords(list);
        log.warn("{}",list);
        return PageUtil.convert(orderPage,Order.class);
    }
}
