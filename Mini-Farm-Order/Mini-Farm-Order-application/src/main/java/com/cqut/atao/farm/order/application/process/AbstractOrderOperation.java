package com.cqut.atao.farm.order.application.process;

import cn.hutool.core.lang.Assert;
import com.cqut.atao.farm.order.application.filter.CheckParamterHandler;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.PlaceOrderReq;
import com.cqut.atao.farm.order.domain.remote.RemoteCartService;
import com.cqut.atao.farm.order.domain.remote.RemoteProductService;
import com.cqut.atao.farm.order.domain.remote.model.req.DeleteCartItemReq;
import com.cqut.atao.farm.order.domain.remote.model.req.OrderInfoReq;
import com.cqut.atao.farm.order.domain.remote.model.req.OrderItemInfo;
import com.cqut.atao.farm.order.domain.service.OrderService;
import com.cqut.atao.farm.order.domain.split.OrderSplitHandler;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AbstractOrderOperation.java
 * @Description 订单操作抽象类
 * @createTime 2023年02月18日 09:54:00
 */
@Slf4j
public abstract class AbstractOrderOperation implements OrderOperationProcess{

    @Resource
    protected OrderService orderService;

    @Resource
    protected RemoteCartService remoteCartService;

    @Resource
    protected RemoteProductService remoteProductService;

    @Resource
    private CheckParamterHandler checkParamterHandler;

    @Resource
    protected OrderSplitHandler orderSplitHandler;

    @Override
    public String createOrder(PlaceOrderReq req) {
        // 参数校验
        checkParamterHandler.doCheck(req);
        // 风险核验
        Assert.isTrue(this.checkRisk(req) , ()->new ServiceException("订单风险异常"));
        // 获取参与结算商品进行订单构建
        Order order = this.buildOrder(req);
        // 获取营销中心优惠信息
        this.getSpecialOffers(order);
        // 核算金额
        Assert.isTrue(order.caculatePayAmount(), ()->new ServiceException("金额核验出错"));
        // 订单生成(涉及到订单拆分)
        String orderNo = this.saveOrder(order);
        // 清空购物车已选中商品列表
        this.deleteCartItem(order);
        // 发送消给延迟队列(取消未支付的订单)
        return orderNo;
    }

    @Override
    public abstract void cancelOrder(String orderId);

    public boolean isParentOrder(String orderSn) {
        log.info("判断是否是父订单");
        return true;
    }


    public Object getSpecialOffers(Order order) {
        log.info("获取优惠信息");
        return "success";
    }

    /**
     * 构建父订单（注入订单编号）
     * @param req {@link PlaceOrderReq}
     * @return {@link Order}
     */
    public Order buildOrder(PlaceOrderReq req) {
        // 信息转换
        Order order = BeanUtil.convert(req, Order.class);
        // 生成订单id
        order.setId(order.generateOrderId());
        // 父订单的parentId就是自身id
        order.setParentId(order.getId());
        // 生成订单号
        order.setOrderSn(order.generateOrderSn());
        // 待付款状态
        order.setStatus(Constants.OrderState.OBLIGATEION.getCode());
        return order;
    }


    public boolean checkRisk(PlaceOrderReq req) {
        log.info("远程调用风险控制");
        return true;
    }

    /**
     * 锁定订单商品库存
     * @param order {@link Order}
     * @return boolean
     */
    @MiniLog
    protected boolean lockStock(Order order) {
        // 商品集合
        List<OrderItemInfo> orderItemInfo = order.getOrderProducts().stream().map(e -> {
            return OrderItemInfo.builder()
                    .num(e.getProductQuantity())
                    .skuId(e.getProductSkuId())
                    .build();
        }).collect(Collectors.toList());
        // 构造请求
         OrderInfoReq req = OrderInfoReq.builder()
                .orderNo(order.getOrderSn())
                .orderItemInfos(orderItemInfo)
                .build();
         log.warn("{}",req);
        return Result.SUCCESS_CODE.equals(remoteProductService.lockProductStock(req).getCode());
    }

    /**
     * 清空购物车中的商品（下单中的商品）
     * @param order
     */
    private void deleteCartItem(Order order) {
        DeleteCartItemReq deleteCartItemReq = DeleteCartItemReq.builder()
                .userId(order.getUserId())
                .skuIds(order.getOrderProducts().stream().map(e->e.getProductSkuId()).collect(Collectors.toList()))
                .build();
        remoteCartService.deleteCartProduct(deleteCartItemReq);
    }

    /**
     * 保存订单
     * @param order {@link Order}
     */
    abstract protected String saveOrder(Order order);

    public abstract void commentOrderStatus(String orderSn, Constants.OrderState waitComment);
}
