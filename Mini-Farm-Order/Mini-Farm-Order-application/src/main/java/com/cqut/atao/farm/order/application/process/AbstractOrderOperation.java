package com.cqut.atao.farm.order.application.process;

import cn.hutool.core.lang.Assert;
import com.cqut.atao.farm.order.application.filter.CheckParamter;
import com.cqut.atao.farm.order.application.filter.CheckParamterHandler;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import com.cqut.atao.farm.order.domain.remote.RemoteCartService;
import com.cqut.atao.farm.order.domain.remote.RemoteProductService;
import com.cqut.atao.farm.order.domain.remote.model.req.*;
import com.cqut.atao.farm.order.domain.remote.model.res.CartItemRes;
import com.cqut.atao.farm.order.domain.remote.model.res.CheckAmountRes;
import com.cqut.atao.farm.order.domain.service.OrderService;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
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

    @Override
    public String createOrder(Order order) {
        // 参数校验
        checkParamterHandler.doCheck(order);
        // 风险核验
        Assert.isTrue(this.checkRisk(order) , ()->new ServiceException("订单风险异常"));
        // 获取购物车已选中商品构建订单
        order = this.generateOrder(order);
        // 获取营销中心优惠信息
        this.getSpecialOffers(order);
        // 核算金额
        Assert.isTrue(order.caculatePayAmount(), ()->new ServiceException("金额核验出错"));
        // 订单拆分

        // 锁定库存
        Assert.isTrue(this.lockStock(order) , ()->new ServiceException("商品库存异常"));
        // 保存订单
        String orderNo = this.saveOrder(order);
        // 清空购物车已选中商品列表
        this.deleteCartItem(order);
        // 发送消给延迟队列(取消未支付的订单)
        return orderNo;
    }

    @Override
    public void cancelOrder(String orderNo) {

    }

    public void splitOrder(Order order) {
        log.info("拆分订单");
    }

    public Object getSpecialOffers(Order order) {
        log.info("获取优惠信息");
        return "success";
    }

    public Order generateOrder(Order order) {
        List<CartItemRes> cartItemRes = remoteCartService.findSelectedCartProduct(order.getUserId()).getData();
        List<OrderProduct> orderProductList = BeanUtil.convert(cartItemRes, OrderProduct.class);
        order.setOrderProducts(orderProductList);
        return order;
    }


    public boolean checkRisk(Order order) {
        log.info("远程调用风险控制");
        return true;
    }

    /**
     * 锁定订单商品库存
     * @param order {@link Order}
     * @return boolean
     */
    private boolean lockStock(Order order) {
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
     * 生成订单
     * @param order {@link Order}
     */
    abstract protected String saveOrder(Order order);


}
