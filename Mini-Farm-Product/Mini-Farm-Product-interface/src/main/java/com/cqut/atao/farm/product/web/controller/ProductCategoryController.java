package com.cqut.atao.farm.product.web.controller;

import com.cqut.atao.farm.product.application.res.ProductCategoryRes;
import com.cqut.atao.farm.product.application.service.ProductCategoryService;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategoryController.java
 * @Description 商品类别控制类
 * @createTime 2023年01月31日 19:53:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "商品分类")
@RequestMapping("/api/product")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @ApiOperation(value = "查询商品分类集合", notes = "返回全部分类")
    @GetMapping("/categories")
    public Result<List<ProductCategoryRes>> listAllProductCategory() {
        return Results.success(productCategoryService.listAllProductCategory());
    }

}
