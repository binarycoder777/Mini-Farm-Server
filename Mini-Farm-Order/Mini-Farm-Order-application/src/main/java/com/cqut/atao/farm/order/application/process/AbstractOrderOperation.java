package com.cqut.atao.farm.order.application.process;

import cn.hutool.core.lang.Assert;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.remote.RemoteCartService;
import com.cqut.atao.farm.order.domain.remote.RemoteProductService;
import com.cqut.atao.farm.order.domain.remote.model.req.CheckAmountReq;
import com.cqut.atao.farm.order.domain.remote.model.req.DeleteCartItemReq;
import com.cqut.atao.farm.order.domain.remote.model.req.LockProductStockReq;
import com.cqut.atao.farm.order.domain.remote.model.res.CheckAmountRes;
import com.cqut.atao.farm.order.domain.service.OrderService;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AbstractOrderOperation.java
 * @Description 订单操作抽象类
 * @createTime 2023年02月18日 09:54:00
 */
public abstract class AbstractOrderOperation implements OrderOperationProcess{


    @Resource
    protected OrderService orderService;

    @Resource
    protected RemoteCartService remoteCartService;

    @Resource
    protected RemoteProductService remoteProductService;

    @Override
    public String createOrder(Order order) {
        // 核算金额
        Assert.isTrue(this.checkOrderAmount(order) , ()->new ServiceException("订单金额异常"));
        // 锁定库存
        Assert.isTrue(this.lockStock(order) , ()->new ServiceException("商品库存异常"));
        // 创建订单
        String orderNo = this.generateOrder(order);
        // 清空购物车已选中商品列表
        this.deleteCartItem(order);
        // 发送消给延迟队列(取消未支付的订单)
        return orderNo;
    }

    @Override
    public void cancelOrder(String orderNo) {

    }



    /**
     * 核验订单金额
     * @param order {@link Order}
     * @return boolean
     */
     private boolean checkOrderAmount(Order order){
         CheckAmountReq req = CheckAmountReq.builder()
                 .skuIds(order.getOrderProducts().stream().map(e -> e.getProductSkuId()).collect(Collectors.toList()))
                 .build();
         CheckAmountRes res = remoteProductService.checkCartProductAmount(req).getData();
         return res.getPayAmount().equals(order.getPayAmount());
     }

    /**
     * 锁定订单商品库存
     * @param order {@link Order}
     * @return boolean
     */
    private boolean lockStock(Order order) {
        LockProductStockReq req = LockProductStockReq.builder()
                .skuIds(order.getOrderProducts().stream().map(e -> e.getProductSkuId()).collect(Collectors.toList()))
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
    abstract protected String generateOrder(Order order);


}
