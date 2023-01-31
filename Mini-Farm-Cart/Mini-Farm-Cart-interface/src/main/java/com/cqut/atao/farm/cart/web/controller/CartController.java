package com.cqut.atao.farm.cart.web.controller;

import com.cqut.atao.farm.cart.application.req.CartItemPageQueryReq;
import com.cqut.atao.farm.cart.application.res.CartItemRes;
import com.cqut.atao.farm.cart.application.service.CartItemService;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartController.java
 * @Description 购物车服务控制类
 * @createTime 2023年01月31日 21:25:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "购物车")
@RequestMapping("/api/cart/product")
public class CartController {

    @Resource
    private CartItemService cartItemService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询购物车商品")
    public Result<PageResponse<CartItemRes>> pageQueryCartItem(CartItemPageQueryReq requestParam) {
        PageResponse<CartItemRes> resultPage = cartItemService.pageQueryCartItem(requestParam);
        return Results.success(resultPage);
    }


}
