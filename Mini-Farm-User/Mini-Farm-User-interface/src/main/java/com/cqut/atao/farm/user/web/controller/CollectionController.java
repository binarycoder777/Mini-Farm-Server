package com.cqut.atao.farm.user.web.controller;

import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import com.cqut.atao.farm.user.application.service.ReceiveAddressMange;
import com.cqut.atao.farm.user.application.service.UserMange;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
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
 * @ClassName CollectionController.java
 * @Description 用户收藏控制层
 * @createTime 2023年03月27日 17:07:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "用户收藏")
@RequestMapping("/api/collect")
public class CollectionController {

    @Resource
    private UserMange userMange;

    @PutMapping("/product")
    @ApiOperation(value = "用户收藏商品")
    public Result<Void> collectProduct(@RequestBody CollectProductReq req) {
        userMange.collecteProduct(req);
        return Results.success();
    }

}
