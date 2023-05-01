package com.cqut.atao.farm.coupon.web.controller;


import com.cqut.atao.farm.coupon.domain.activity.kill.SecondKillActivity;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.*;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.res.KillACtivityRes;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.res.KillProductRes;
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

    @PutMapping("/kill/product/pass/")
    @ApiOperation(value = "审批秒杀商品")
    public Result<Void> passKillProduct(PassProductReq req) {
        secondKillActivity.passKillProduct(req);
        return Results.success();
    }

    @GetMapping("/kill/product/{killId}")
    @ApiOperation(value = "根据秒杀场次查询秒杀商品")
    public Result<List<KillProductRes>> getKillProduct(@PathVariable("killId") Long killId) {
        List<KillProductRes> res = secondKillActivity.pageQueryKillProduct(killId);
        return Results.success(res);
    }

    @PostMapping("/kill/product/buy")
    @ApiOperation(value = "抢购秒杀商品")
    public Result<String> buyKillProduct(@RequestBody KillOrderReq req) {
        String killOrderSn = secondKillActivity.buyKillProduct(req);
        return Results.success(killOrderSn);
    }

    @PostMapping("/kill/product/notice")
    @ApiOperation(value = "提醒我抢购")
    public Result<Void> noticeBuyKillProduct(@RequestBody addKillNoticeReq req) {
        secondKillActivity.addKillNotice(req);
        return Results.success();
    }

    @PostMapping("/list")
    @ApiOperation(value = "列表")
    public Result<PageResponse<KillACtivityRes>> activityPage(@RequestBody ActivityPageReq req ) {
        PageResponse<KillACtivityRes> res = secondKillActivity.activityPage(req);
        return Results.success(res);
    }

    @PostMapping("/status/{id}")
    @ApiOperation(value = "上线/下线")
    public Result<Void> activityStatus(@PathVariable("id")Long id) {
        secondKillActivity.activityStatus(id);
        return Results.success();
    }

    @PostMapping("/kill/update")
    @ApiOperation(value = "更新秒杀场次")
    public Result<Void> updateKillSeconds(@RequestBody DeployActivityReq req) {
        secondKillActivity.updateActivity(req);
        return Results.success();
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除活动")
    public Result<Void> activityDelete(@PathVariable("id")Long id) {
        secondKillActivity.activityDelete(id);
        return Results.success();
    }

}
