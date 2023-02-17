package com.cqut.atao.farm.cart.web.controller;


import com.cqut.atao.farm.cart.application.service.CartItemService;
import com.cqut.atao.farm.cart.domain.mode.req.*;
import com.cqut.atao.farm.cart.domain.mode.res.CartItemRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
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
import java.util.List;

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

    @GetMapping("/selected/{userId}")
    @ApiOperation(value = "查询已选中的购物车商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户 id", required = true, example = "1547742028312375296")
    })
    public Result<List<CartItemRes>> findSelectedCartItem(@PathVariable("userId") String userId) {
        List<CartItemRes> response = cartItemService.getSelectedCartItemInfo(userId);
        return Results.success(response);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增购物车商品")
    public Result<Void> addCartItem(@RequestBody CartItemAddReq req) {
        cartItemService.addCartItem(req);
        return Results.success();
    }

    @PutMapping("/modify")
    @ApiOperation(value = "修改已选中的购物车商品")
    public Result<Void> modifySelectedCartItem(@RequestBody CartItemSelectedReq req) {
        cartItemService.updateSelectedCartItem(req);
        return Results.success();
    }

    @PutMapping("/nums")
    @ApiOperation(value = "修改购物车商品数量")
    public Result<Void> updateNumCartItem(@RequestBody CartItemNumReq requestParam) {
        cartItemService.updateCartItemNum(requestParam);
        return Results.success();
    }

    @DeleteMapping
    @ApiOperation(value = "清除购物车商品")
    public Result<Void> clearCartProduct(@RequestBody CartItemClearReq requestParam) {
        cartItemService.clearCartItem(requestParam);
        return Results.success();
    }

}
