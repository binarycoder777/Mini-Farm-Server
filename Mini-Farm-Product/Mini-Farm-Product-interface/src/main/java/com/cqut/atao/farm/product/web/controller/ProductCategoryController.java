package com.cqut.atao.farm.product.web.controller;

import com.cqut.atao.farm.product.application.admin.AdminService;
import com.cqut.atao.farm.product.application.res.ProductCategoryRes;
import com.cqut.atao.farm.product.application.service.ProductCategoryMange;
import com.cqut.atao.farm.product.domain.mode.vo.ProductCategoryVO;
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

    @Resource
    private AdminService adminService;

    private final ProductCategoryMange productCategoryService;

    @ApiOperation(value = "查询商品分类集合", notes = "返回全部分类")
    @GetMapping("/categories")
    public Result<List<ProductCategoryRes>> listAllProductCategory() {
        return Results.success(productCategoryService.listAllProductCategory());
    }

    @ApiOperation(value = "查询商品分类集合(admin)", notes = "返回全部分类")
    @GetMapping("/categories/list")
    public Result<List<ProductCategoryVO>> productCategoryList() {
        return Results.success(adminService.productCategoryList());
    }

    @ApiOperation(value = "新增分类")
    @PostMapping("/categories/add")
    public Result<Void> addProductCategory(@RequestBody ProductCategoryVO productCategoryVO) {
        adminService.addProductCategory(productCategoryVO);
        return Results.success();
    }

    @ApiOperation(value = "修改分类")
    @PutMapping("/categories/update/")
    public Result<Void> updateProductCategory(@RequestBody ProductCategoryVO productCategoryVO) {
        adminService.updateProductCategory(productCategoryVO);
        return Results.success();
    }

    @ApiOperation(value = "删除分类")
    @DeleteMapping("/categories/delete/{id}")
    public Result<Void> deleteProductCategory(@PathVariable("id") Long id) {
        adminService.delProductCategory(id);
        return Results.success();
    }

    @ApiOperation(value = "分类详情")
    @GetMapping("/categories/detail/{id}")
    public Result<ProductCategoryVO> productCategoryDetail(@PathVariable("id") Long id) {
        ProductCategoryVO res = adminService.productCategoryDetail(id);
        return Results.success(res);
    }


}
