package com.cqut.atao.farm.product.web.controller;

import com.cqut.atao.farm.product.domain.activity.kill.SecondKillActivity;
import com.cqut.atao.farm.product.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.product.domain.activity.kill.model.req.DeployActivityReq;
import com.cqut.atao.farm.product.domain.activity.kill.model.res.KillACtivityRes;
import com.cqut.atao.farm.product.domain.remote.model.req.PlaceOrderReq;
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
 * @ClassName ActivityController.java
 * @Description 活动控制
 * @createTime 2023年03月14日 13:55:00
 */

@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "秒杀场次")
@RequestMapping("/api/promotion/activity")
public class KillActivityController {

    @Resource
    private SecondKillActivity secondKillActivity;

    @PostMapping("/kill/create")
    @ApiOperation(value = "创建秒杀场次")
    public Result<Void> createKillSeconds(@RequestBody DeployActivityReq req) {
        secondKillActivity.deployActivity(req);
        return Results.success();
    }

    @GetMapping("/kill/list")
    @ApiOperation(value = "查询秒杀场次")
    public Result<List<KillACtivityRes>> listKillSeconds() {
        List<KillACtivityRes> list =  secondKillActivity.queryKillActivity();
        return Results.success(list);
    }

    @PostMapping("/kill/product/add")
    @ApiOperation(value = "添加秒杀商品")
    public Result<Void> addKillProduct(@RequestBody AddKillProductReq req) {
        secondKillActivity.addKillProduct(req);
        return Results.success();
    }

    @PostMapping("/kill/product/{killId}")
    @ApiOperation(value = "根据秒杀场次查询秒杀商品")
    public Result<Void> getKillProduct(@PathVariable("killId") Long killId) {
//        secondKillActivity.getKillProductByKillId(killId);
        return Results.success();
    }

    @PostMapping("/kill/product/buy")
    @ApiOperation(value = "抢购秒杀商品")
    public Result<Void> buyKillProduct(@RequestBody PlaceOrderReq req) {
        return Results.success();
    }


}
