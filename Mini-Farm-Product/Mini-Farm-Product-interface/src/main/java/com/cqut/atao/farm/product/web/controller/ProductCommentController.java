package com.cqut.atao.farm.product.web.controller;

import com.cqut.atao.farm.product.application.res.ProductCategoryRes;
import com.cqut.atao.farm.product.application.service.ProductCommentMange;
import com.cqut.atao.farm.product.domain.mode.req.AddCommentReq;
import com.cqut.atao.farm.product.domain.mode.req.CommentProductReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCommentReq;
import com.cqut.atao.farm.product.domain.mode.res.CommentRes;
import com.cqut.atao.farm.product.domain.mode.res.CommentStatisticsRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCommentController.java
 * @Description 商品评论controller类
 * @createTime 2023年04月08日 13:36:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "商品评论")
@RequestMapping("/api/product/comment")
public class ProductCommentController {

    @Resource
    private ProductCommentMange productCommentMange;

    @ApiOperation(value = "新增商品评论")
    @PostMapping("/add")
    public Result<Void> commentProduct(@RequestBody CommentProductReq req) {
        productCommentMange.doComment(req);
        return Results.success();
    }

    @ApiOperation(value = "评论类型分类及分类数统计")
    @GetMapping("/category/{productSpuId}")
    public Result<List<CommentStatisticsRes>> commentCategoryStatistics(@PathVariable("productSpuId")Long productSpuId) {
        List<CommentStatisticsRes> list = productCommentMange.categoryStatisticsComment(productSpuId);
        return Results.success(list);
    }

    @ApiOperation(value = "根据评论类型分页查询")
    @GetMapping("/page")
    public Result<PageResponse<CommentRes>> pageQueryComment(PageCommentReq req) {
        PageResponse<CommentRes> res = productCommentMange.pageQueryComment(req);
        return Results.success(res);
    }



}
