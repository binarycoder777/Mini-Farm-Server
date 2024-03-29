package com.cqut.atao.farm.order.domain.repository;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterAddressReq;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.domain.model.req.SendProductReq;
import com.cqut.atao.farm.order.domain.model.res.OrderSalesVolume;
import com.cqut.atao.farm.order.domain.model.res.PendingTransactions;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

import java.util.Date;
import java.util.List;


/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderRepository.java
 * @Description 订单仓储层
 * @createTime 2023年02月04日 16:57:00
 */
public interface OrderRepository {

    /**
     * 保存订单
     * @param order {@link Order}
     */
    void saveOrder(Order order);


    /**
     * 状态流转
     * @param orderId 订单号
     * @param currentState 当前状态
     * @param nextState 下一状态
     * @return 结果
     */
    boolean alterState(String orderId, Enum<Constants.OrderState> currentState, Enum<Constants.OrderState> nextState);

    /**
     * 获取父订单id下的所有订单
     * @param parentOrderId 父订单id
     * @return {@link Order}
     */
    List<Order> getSubOrder(String parentOrderId);


    /**
     * 根据订单id查找订单
     * @param orderId 订单id
     * @return {@link Order}
     */
    Order selectOrderByOrderId(String orderId);

    /**
     * 保存订单
     * @param order {@link Order}
     */
    void saveParentOrder(Order order);

    /**
     * 查询订单分页信息
     * @param req 分页请求
     * @return 分页结果
     */
    PageResponse<Order> queryOrderPageInfo(OrderPageReq req);

    /**
     * 根据订单号查询对应查询商家ID
     * @param orderSn
     * @return
     */
    Long queryMerchantId(String orderSn);

    Order queryOrderInfo(String orderSn);

    PageResponse<Order> queryOrderPageInfoAdmin(OrderPageReq req);

    void orderDelivery(SendProductReq req);

    void updateOrder(AlterAddressReq req);

    OrderSalesVolume orderSalesVolumeStatistics(Date current);

    PendingTransactions pendingTransactions();

    OrderSalesVolume sales(Date one, Date date);
}
