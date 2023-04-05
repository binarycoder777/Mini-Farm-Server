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
 * @ClassName UnpiadOrder.java
 * @Description 查询未支付的订单
 * @createTime 2023年04月04日 08:59:00
 */
@Component
public class UnpiadOrder implements PageQueryOrderInfo {

    @Resource
    private OrderDAO orderDAO;

    @Resource
    private OrderItemDAO orderItemDAO;

    @Override
    public PageResponse<Order> queryOrderPageInfo(OrderPageReq req) {
        // 查询父订单
        List<OrderPO> parentOrders = orderDAO.pageParentOrder(req);
        // 遍历父订单
        parentOrders.forEach(o -> {
            // 查询父订单的子订单
            List<OrderPO> subOrders = orderDAO.listSubOrder(req.getUserId(), o.getParentId(), req.getOrderStatus());
            List<OrderItemPO> orderProductList = Lists.newArrayList();
            // 查询子订单对应的商品详情
            subOrders.forEach(e -> {
                List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class)
                        .eq(OrderItemPO::getOrderSn, e.getOrderSn()));
                orderProductList.addAll(orderItemPOS);
            });
            o.setOrderProducts(orderProductList);
        });
        // 查询数量
        int nums = orderDAO.countParentOrder(req.getOrderStatus());
        Page<OrderPO> orderPOPage = new Page<>(req.getCurrent(), req.getSize(), nums);
        orderPOPage.setRecords(parentOrders);
        return PageUtil.convert(orderPOPage, Order.class);
    }

}
