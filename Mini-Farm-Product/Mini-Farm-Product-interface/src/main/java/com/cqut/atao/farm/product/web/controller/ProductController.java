package com.cqut.atao.farm.product.web.controller;

import com.cqut.atao.farm.product.application.req.SearchProductReq;
import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.application.res.ProductRes;
import com.cqut.atao.farm.product.application.service.ProductMange;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductController.java
 * @Description 商品服务
 * @createTime 2023年01月30日 15:47:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "商品服务")
@RequestMapping("/api/product")
public class ProductController {

    @Resource
    private ProductMange productMange;

    @GetMapping("/spu/{spuId}")
    @ApiOperation(value = "根据 spuId 查询商品详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "spuId", value = "商品 spuId", required = true, example = "1477055850256982016")
    })
    public Result<ProductRes> getProductBySpuId(@PathVariable("spuId") String spuId) {
        ProductRes result = productMange.getProductBySpuId(Long.parseLong(spuId));
        return Results.success(result);
    }

    @GetMapping("/search")
    @ApiOperation(value = "根据用户搜索进行商品查询")
    public Result<PageResponse<ProductProfileRes>> searchProduct(SearchProductReq req) {
        PageResponse<ProductProfileRes> productProfileResPageResponse = productMange.searchProduct(req);
        return Results.success(productProfileResPageResponse);
    }


    @GetMapping("/recommand/{userId}")
    @ApiOperation(value = "根据用户喜好进行商品推荐")
    public Result<PageResponse<ProductProfileRes>> recommandProduct(@PathVariable("userId") String userId) {
        return null;
    }

}
