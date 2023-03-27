package com.cqut.atao.farm.order.web.controller;

import com.cqut.atao.farm.order.application.process.OrderOperationProcess;
import com.cqut.atao.farm.order.application.process.impI.KillOrderOperationProcessImpI;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.PlaceOrderReq;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
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
    private OrderOperationProcess orderOperationProcess;

    @Resource
    private KillOrderOperationProcessImpI killOrderOperationProcessImpI;

    @PostMapping("/create")
    @ApiOperation("商品下单")
    public Result<String> createOrder(@RequestBody PlaceOrderReq req) {
        String orderNo = orderOperationProcess.createOrder(req);
        return Results.success(orderNo);
    }

    @PostMapping("/cancel/{orderNo}")
    @ApiOperation("取消下单")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "orderNo", value = "订单号", required = true, example = "1593868838284611584")
    )
    public Result<Void> createOrder(@PathVariable String orderNo) {
        orderOperationProcess.cancelOrder(orderNo);
        return Results.success();
    }

    @PostMapping("/kill/create")
    @ApiOperation("秒杀商品下单")
    public Result<String> createKillOrder(@RequestBody PlaceOrderReq req) {
        String orderNo = killOrderOperationProcessImpI.createOrder(req);
        return Results.success(orderNo);
    }

    @PostMapping("/kill/cancel/{orderNo}")
    @ApiOperation("取消秒杀下单")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "orderNo", value = "订单号", required = true, example = "1593868838284611584")
    )
    public Result<Void> cancelKillOrder(@PathVariable String orderNo) {
        killOrderOperationProcessImpI.cancelOrder(orderNo);
        return Results.success();
    }


}
