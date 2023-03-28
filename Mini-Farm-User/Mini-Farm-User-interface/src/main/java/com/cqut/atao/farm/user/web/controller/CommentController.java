package com.cqut.atao.farm.user.web.controller;

import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import com.cqut.atao.farm.user.application.service.UserMange;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CommentController.java
 * @Description 用户评论控制层
 * @createTime 2023年03月27日 21:20:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "用户评论")
@RequestMapping("/api/comment")
public class CommentController {

    @Resource
    private UserMange userMange;

    @PostMapping("/product")
    @ApiOperation(value = "用户评论商品")
    public Result<Void> commentProduct(@RequestBody CommentProductReq req) {
        userMange.commentProduct(req);
        return Results.success();
    }

}
