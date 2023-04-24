package com.cqut.atao.farm.order.web.controller;

import com.cqut.atao.farm.order.domain.model.req.ReturnProductReq;
import com.cqut.atao.farm.order.domain.refund.OrderRefundHandler;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyDetails;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyRes;
import com.cqut.atao.farm.order.domain.refund.model.ReturnOrderApplyReq;
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
    @ApiOperation("订单退货详情")
    public Result<OrderReturnApplyDetails> returnOfgoodsList(@PathVariable("id") Long id) {
        OrderReturnApplyDetails res = orderRefundHandler.returnProductsDetail(id);
        return Results.success(res);
    }

}
