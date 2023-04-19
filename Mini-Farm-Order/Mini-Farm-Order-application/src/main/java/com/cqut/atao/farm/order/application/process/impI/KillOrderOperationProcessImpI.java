package com.cqut.atao.farm.order.application.process.impI;

import cn.hutool.core.lang.Assert;
import com.cqut.atao.farm.order.application.filter.CheckParamterHandler;
import com.cqut.atao.farm.order.application.process.OrderOperationProcess;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.AlterOrderStateReq;
import com.cqut.atao.farm.order.domain.model.req.PlaceOrderReq;
import com.cqut.atao.farm.order.domain.service.OrderService;
import com.cqut.atao.farm.order.domain.split.OrderSplitHandler;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateOrderProcessImpI.java
 * @Description 创建秒杀订单实流程现类
 * @createTime 2023年02月04日 16:05:00
 */
@Slf4j
@Service
public class KillOrderOperationProcessImpI implements OrderOperationProcess {

    @Resource
    protected OrderService orderService;

    @Resource
    private CheckParamterHandler checkParamterHandler;

    @Resource
    protected OrderSplitHandler orderSplitHandler;

    @Override
    public String createOrder(PlaceOrderReq req) {
        // 参数校验
        checkParamterHandler.doCheck(req);
        // 风险核验
        Assert.isTrue(this.checkRisk(req), () -> new ServiceException("订单风险异常"));
        // 获取参与结算商品进行订单构建
        Order order = this.buildOrder(req);
        // 核算金额
        Assert.isTrue(order.caculatePayAmount(), () -> new ServiceException("金额核验出错"));
        // 订单生成
        return this.saveOrder(order);
    }

    private String saveOrder(Order order) {
        // 保存父订单
        orderService.createParentOrder(order);
        // 父订单拆分（父订单含汇总信息，子订单包含详细信息）
        List<Order> orders = orderSplitHandler.splitOrder(order);
        for (Order subOrder : orders) {
            // 保存子订单
            orderService.createOrder(subOrder);
        }
        // 返回父订单号
        return order.getOrderSn();
    }

    @Override
    public void cancelOrder(String orderId) {
        // 获取该订单下的订单集合
        List<Order> orderList = orderService.getSubOrder(orderId);
        // 订单状态流转为取消状态
        orderList.forEach(e -> {
            AlterOrderStateReq req = AlterOrderStateReq.builder()
                    .orderSn(e.getOrderSn())
                    .currentSate(Constants.OrderState.getStateByCode(e.getStatus()))
                    .build();
            orderService.cancelOrder(req);
        });
    }


    /**
     * 构建订单（注入订单编号）
     *
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


}
