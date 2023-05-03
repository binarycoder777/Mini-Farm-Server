package com.cqut.atao.farm.order.web.controller;

import com.cqut.atao.farm.order.domain.operate.OrderOperateHandler;
import com.cqut.atao.farm.order.domain.operate.model.OperateReq;
import com.cqut.atao.farm.order.domain.operate.model.OperateRes;
import com.cqut.atao.farm.order.domain.refund.OrderRefundHandler;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyDetails;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyRes;
import com.cqut.atao.farm.order.domain.refund.model.req.ConfirmReturnOrderReq;
import com.cqut.atao.farm.order.domain.refund.model.req.ReturnOrderApplyReq;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderReturnApplyController.java
 * @Description 退货处理
 * @createTime 2023年04月23日 14:27:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "商品订单退货")
@RequestMapping("/api/order/return")
public class OrderReturnApplyController {

    @Resource
    private OrderRefundHandler orderRefundHandler;

    @Resource
    private OrderOperateHandler orderOperateHandler;

    @PostMapping("/products")
    @ApiOperation("用户订单退货")
    public Result<Void> returnOfgoods(@RequestBody ReturnOrderApplyReq req) {
        orderRefundHandler.returnProducts(req);
        return Results.success();
    }

    @PostMapping("/list")
    @ApiOperation("订单退货列表")
    public Result<PageResponse<OrderReturnApplyRes>> returnOfgoodsList(@RequestBody PageRequest request) {
        PageResponse<OrderReturnApplyRes> res = orderRefundHandler.returnProductsList(request);
        return Results.success(res);
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("订单退货详情（通过id查询）")
    public Result<OrderReturnApplyDetails> returnOfgoodsList(@PathVariable("id") Long id) {
        OrderReturnApplyDetails res = orderRefundHandler.returnProductsDetail(id);
        return Results.success(res);
    }

    @GetMapping("/detail/by/{orderSn}")
    @ApiOperation("订单退货详情(通过订单号查询)")
    public Result<OrderReturnApplyDetails> returnOfgoodsListByOrderSn(@PathVariable("orderSn") String orderSn) {
        OrderReturnApplyDetails res = orderRefundHandler.returnProductsDetailByOrderSn(orderSn);
        return Results.success(res);
    }

    @PutMapping("/confirm")
    @ApiOperation("确认退货")
    public Result<Void> returnOfgoodsConfirm(@RequestBody ConfirmReturnOrderReq req) {
        orderRefundHandler.returnProductsConfirm(req);
        return Results.success();
    }

    @PutMapping("/refuse/{id}")
    @ApiOperation("拒绝退货")
    public Result<Void> returnOfgoodsRefuse(@PathVariable("id")Long id) {
        orderRefundHandler.returnProductsRefuse(id);
        return Results.success();
    }

    @PutMapping("/recive/{id}")
    @ApiOperation("确认收货(退货)")
    public Result<Void> returnOfgoodsRecive(@PathVariable("id")Long id) {
        orderRefundHandler.returnOfgoodsRecive(id);
        return Results.success();
    }

    @PutMapping("/money/{orderSn}")
    @ApiOperation("确认退款(退货)")
    public Result<Void> refundMoney(@PathVariable("orderSn")String orderSn) {
        orderRefundHandler.returnOfgoodsRefundMoney(orderSn);
        return Results.success();
    }

    @PostMapping("/operate/")
    @ApiOperation("记录订单操作")
    public Result<Void> operateOrder(@RequestBody OperateReq req) {
        orderOperateHandler.operateOrder(req);
        return Results.success();
    }

    @GetMapping("/operate/list/{orderSn}")
    @ApiOperation("订单操作列表")
    public Result<List<OperateRes>> operateList(@PathVariable("orderSn")String orderSn) {
        List<OperateRes> list = orderOperateHandler.operateList(orderSn);
        return Results.success(list);
    }

}
