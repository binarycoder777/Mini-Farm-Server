package com.cqut.atao.farm.user.web.controller;

import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import com.cqut.atao.farm.user.application.service.ReceiveAddressMange;
import com.cqut.atao.farm.user.domain.model.req.ReceiveAddressReq;
import com.cqut.atao.farm.user.domain.model.res.ReceiveAddressRes;
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
 * @ClassName ReceiveAddressController.java
 * @Description 收货地址控制层
 * @createTime 2023年01月13日 21:02:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "收货地址")
@RequestMapping("/api/address")
public class ReceiveAddressController {

    @Resource
    private ReceiveAddressMange receiveAddressMange;

    @GetMapping("/{userId}/receive-address")
    @ApiOperation(value = "获取用户收货地址", notes = "根据用户ID获取用户收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户 id", required = true, example = "1547742028312375296")
    })
    public Result<List<ReceiveAddressRes>> listReceiveAddress(@PathVariable("userId") String customerUserId) {
        return Results.success(receiveAddressMange.queryAddressList(customerUserId));
    }

    @PostMapping("/save/receive-address")
    @ApiOperation(value = "保存用户收货地址", notes = "保存上传的用户收货地址")
    public Result<Void> saveReceiveAddress(@RequestBody ReceiveAddressReq req) {
        receiveAddressMange.saveReceiveAddress(req);
        return Results.success();
    }

    @DeleteMapping("/delete/receive-address/{id}")
    @ApiOperation(value = "删除用户收货地址", notes = "删除上传的用户收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户收货地址id", required = true, example = "123456")
    })
    public Result<Void> deleteReceiveAddress(@PathVariable String id) {
        receiveAddressMange.deleteReceiveAddress(id);
        return Results.success();
    }


}
