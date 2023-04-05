package com.cqut.atao.farm.pay.web.controller;

import com.cqut.atao.farm.pay.application.PayService;
import com.cqut.atao.farm.pay.application.req.PayResultReq;
import com.cqut.atao.farm.pay.application.req.RemitReq;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayController.java
 * @Description 支付控制器
 * @createTime 2023年02月22日 09:30:00
 */
@Api
@MiniLog
@RestController
@RequestMapping("/api/pay")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/order")
    @ApiOperation("付款订单")
    public Result<Object> payMoney(@RequestBody PayReq req){
        Object o = payService.payMoneySign(req);
        return Results.success(o);
    }

    @PostMapping("/pay/notify")
    @ApiOperation("三方支付后回调通知（支付成功还是失败）")
    public Result<Object> notifyPayResult(@RequestBody PayResultReq req){
        Object o = payService.payMoneyResult(req);
        return Results.success(o);
    }

    @PutMapping("/refund/order")
    @ApiOperation("发起订单退款")
    public Result<Void> refundMoney(String orderSn){
        payService.refundMoney(orderSn);
        return Results.success();
    }

    @PostMapping("/refund/notify")
    @ApiOperation("订单退款通知回调接口")
    public Result<Void> notifyRefundMoney(@RequestBody Object o){
        payService.refundMoneyResult(o);
        return Results.success();
    }

    @PostMapping("/remit/order")
    @ApiOperation("商家订单结算")
    public Result<Void> remitOrder(@RequestBody RemitReq req){
        payService.remit(req);
        return Results.success();
    }

}
