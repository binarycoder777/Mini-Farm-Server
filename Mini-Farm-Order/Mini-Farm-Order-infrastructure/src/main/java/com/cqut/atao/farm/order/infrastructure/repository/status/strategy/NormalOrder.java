package com.cqut.atao.farm.order.infrastructure.repository.status.strategy;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
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
 * @ClassName UnpiadOrder.java
 * @Description 查询正常的订单
 * @createTime 2023年04月04日 08:59:00
 */
@Component
public class NormalOrder implements PageQueryOrderInfo {

    @Resource
    private OrderDAO orderDAO;

    @Resource
    private OrderItemDAO orderItemDAO;

    @Override
    public PageResponse<Order> queryOrderPageInfo(OrderPageReq req) {
        // 查询子订单
        List<OrderPO> subOrders = orderDAO.pageSubOrder(req);
        // 查询订单商品详情
        subOrders.forEach(o -> {
            List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class)
                    .eq(OrderItemPO::getOrderSn, o.getOrderSn()));
            o.setOrderProducts(orderItemPOS);
        });
        // 查询数量
        int nums = orderDAO.countSubOrder(req.getOrderStatus());
        Page<OrderPO> orderPOPage = new Page<>(req.getCurrent(), req.getSize(), nums);
        orderPOPage.setRecords(subOrders);
        return PageUtil.convert(orderPOPage, Order.class);
    }

}
