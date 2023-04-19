package com.cqut.atao.farm.product.web.controller;

import com.cqut.atao.farm.product.application.service.ProductCollectMange;
import com.cqut.atao.farm.product.domain.mode.req.CollectProductReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCollectProductReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@Api(tags = "商品收藏")
@RequestMapping("/api/collect")
public class ProductCollectionController {

    @Resource
    private ProductCollectMange productCollectMange;

    @PutMapping("/product")
    @ApiOperation(value = "用户收藏商品")
    public Result<Void> collectProduct(@RequestBody CollectProductReq req) {
        productCollectMange.collecteProduct(req);
        return Results.success();
    }

    @GetMapping("/product/{userId}/{productId}")
    @ApiOperation(value = "用户收藏商品查询")
    public Result<Boolean> collectProduct(@PathVariable(value = "userId") Long userId,
                                       @PathVariable(value = "productId") Long productId) {
        boolean status = productCollectMange.getProductCollectStatus(userId,productId);
        return Results.success(status);
    }

    @GetMapping("/product/page")
    @ApiOperation(value = "分页查询用户收藏商品")
    public Result<PageResponse<ProductSpuVO>> pageQueryCollectProduct(PageCollectProductReq req) {
        PageResponse<ProductSpuVO> productSpuVOPageResponse = productCollectMange.pageQueryProductCollect(req);
        return Results.success(productSpuVOPageResponse);
    }

}
