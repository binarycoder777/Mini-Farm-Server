package com.cqut.atao.farm.user.web.controller;

import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import com.cqut.atao.farm.user.domain.model.vo.ReceiveAddressVO;
import com.cqut.atao.farm.user.application.service.ReceiveAddressMange;
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
    public Result<List<ReceiveAddressVO>> listReceiveAddress(@PathVariable("userId") String customerUserId) {
        return Results.success(receiveAddressMange.queryAddressList(customerUserId));
    }

    @GetMapping("/add/receive-address")
    @ApiOperation(value = "新增用户收货地址", notes = "保存上传的用户收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ReceiveAddressVO", value = "用户收货地址", required = true, example = "ReceiveAddressVO类")
    })
    public Result<Void> addReceiveAddress(@RequestBody ReceiveAddressVO req) {
        receiveAddressMange.addReceiveAddress(req);
        return Results.success();
    }

}
