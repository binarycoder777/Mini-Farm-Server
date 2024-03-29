package com.cqut.atao.farm.order.web.controller;

import com.cqut.atao.farm.order.application.process.impI.KillOrderOperationProcessImpI;
import com.cqut.atao.farm.order.application.process.impI.OrderOperationProcessImpI;
import com.cqut.atao.farm.order.application.record.OperateHandler;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.*;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderController.java
 * @Description 订单控制类
 * @createTime 2023年02月04日 15:21:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "商品订单")
@RequestMapping("/api/order")
public class OrderController {

    @Resource
    private OperateHandler operateHandler;

    @Resource
    private OrderOperationProcessImpI orderOperationProcessImpI;

    @Resource
    private KillOrderOperationProcessImpI killOrderOperationProcessImpI;


    @GetMapping("/detail/{orderSn}")
    @ApiOperation("订单详情信息")
    public Result<Order> orderDetail(@PathVariable("orderSn") String orderSn) {
        Order order = orderOperationProcessImpI.getOrderInfo(orderSn);
        return Results.success(order);
    }

    @GetMapping("/page")
    @ApiOperation("订单分页查询")
    public Result<PageResponse<Order>> createOrder(OrderPageReq req) {
         PageResponse<Order> orderPageResponse = orderOperationProcessImpI.pageQueryOrder(req);
        return Results.success(orderPageResponse);
    }

    @PostMapping("/page/admin")
    @ApiOperation("订单分页查询(admin)")
    public Result<PageResponse<Order>> orderList(@RequestBody OrderPageReq req) {
        PageResponse<Order> orderPageResponse = orderOperationProcessImpI.pageQueryOrderAdmin(req);
        return Results.success(orderPageResponse);
    }

    @PostMapping("/create")
    @ApiOperation("商品下单")
    public Result<String> createOrder(@RequestBody PlaceOrderReq req) {
        String orderNo = orderOperationProcessImpI.createOrder(req);

        operateHandler.doOperate(orderNo,0,"用户商品下单");
        return Results.success(orderNo);
    }

    @PutMapping("/cancel/{parentOrderId}")
    @ApiOperation("取消下单")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "parentOrderId", value = "父订单id", required = true, example = "1593868838284611584")
    )
    public Result<Void> createOrder(@PathVariable(value = "parentOrderId") String parentOrderId) {
        orderOperationProcessImpI.cancelOrder(parentOrderId);

        operateHandler.doOperate(parentOrderId,-1,"取消订单");
        return Results.success();
    }

    @PostMapping("/kill/create")
    @ApiOperation("秒杀商品下单")
    public Result<String> createKillOrder(@RequestBody PlaceOrderReq req) {
        String orderNo = killOrderOperationProcessImpI.createOrder(req);

        operateHandler.doOperate(orderNo,0,"秒杀下单");
        return Results.success(orderNo);
    }

    @PostMapping("/kill/cancel/{orderNo}")
    @ApiOperation("取消秒杀下单")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "orderNo", value = "订单号", required = true, example = "1593868838284611584")
    )
    public Result<Void> cancelKillOrder(@PathVariable String orderNo) {
        killOrderOperationProcessImpI.cancelOrder(orderNo);

        operateHandler.doOperate(orderNo,-1,"取消下单");
        return Results.success();
    }

    @PostMapping("/remind/delivery/{orderNo}")
    @ApiOperation("提醒商家订单发货")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "orderNo", value = "订单号", required = true, example = "1593868838284611584")
    )
    public Result<Void> remindDelivery(@PathVariable String orderNo) {
        orderOperationProcessImpI.remindOrder(orderNo);
        return Results.success();
    }

    @PutMapping("/merchant/send/")
    @ApiOperation("商家订单发货")
    public Result<Void> sendOrder(@RequestBody SendProductReq req) {
        orderOperationProcessImpI.deliveryOfgoods(req);
        return Results.success();
    }


    @PutMapping("/confirm/{orderNo}")
    @ApiOperation("用户确认收货")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "orderNo", value = "订单号", required = true, example = "1593868838284611584")
    )
    public Result<Void> confirmOrder(@PathVariable String orderNo) {
        orderOperationProcessImpI.confirmOrder(orderNo);

        operateHandler.doOperate(orderNo,3,"用户确认收货");
        return Results.success();
    }

    @GetMapping("/comment/status/{orderSn}")
    @ApiOperation("评论订单")
    public Result<Void> alterOrderStatusToComment(@PathVariable("orderSn") String orderSn) {
        orderOperationProcessImpI.commentOrderStatus(orderSn, Constants.OrderState.WAIT_COMMENT);
        return Results.success();
    }

    @PutMapping("/address/")
    @ApiOperation("修改订单收货地址")
    public Result<Void> alterOrderAddress(@RequestBody AlterAddressReq req) {
        orderOperationProcessImpI.alterOrderAddress(req);
        return Results.success();
    }

}
