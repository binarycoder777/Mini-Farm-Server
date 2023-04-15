package com.cqut.atao.farm.product.web.controller;

import com.cqut.atao.farm.product.application.service.ProductFootMange;
import com.cqut.atao.farm.product.domain.mode.req.UserFoot;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
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
 * @ClassName ProductFootController.java
 * @Description 商品足迹
 * @createTime 2023年04月14日 16:10:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "用户浏览商品的足迹")
@RequestMapping("/api/product/foot")
public class ProductFootController {

    @Resource
    private ProductFootMange productFootMange;


    @ApiOperation(value = "查询用户足迹")
    @GetMapping("/list/{userId}")
    public Result<List<ProductSpuVO>> listAllProductFoot(@PathVariable("userId")Long userId) {
        return Results.success(productFootMange.productFootList(userId));
    }

    @ApiOperation(value = "新增用户足迹")
    @PostMapping("/add")
    public Result<Void> addUserFoot(@RequestBody UserFoot foot) {
        productFootMange.addUserFoot(foot);
        return Results.success();
    }

    @ApiOperation(value = "删除用户足迹")
    @PutMapping("/delete")
    public Result<Void> deleteUserFoot(@RequestBody UserFoot foot) {
        productFootMange.deleteUserFoot(foot);
        return Results.success();
    }

}
