package com.cqut.atao.farm.product.web.controller;

import com.cqut.atao.farm.product.application.req.CheckAmountReq;
import com.cqut.atao.farm.product.application.req.ProductCategoryReq;
import com.cqut.atao.farm.product.application.req.SearchProductReq;
import com.cqut.atao.farm.product.application.res.CheckAmountRes;
import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.application.res.ProductRes;
import com.cqut.atao.farm.product.application.service.ProductMange;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.req.BatchQueryReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
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

    @PostMapping("/bach/query/spu/")
    @ApiOperation(value = "根据 spuId和skuid 查询商品")
    public Result<List<Product>> getProductBySpuId(@RequestBody List<BatchQueryReq> reqs) {
        List<Product> list = productMange.queryProducts(reqs);
        return Results.success(list);
    }

    @GetMapping("/spu/category")
    @ApiOperation(value = "根据 categoryId 查询商品列表")
    public Result<PageResponse<ProductProfileRes>> getProductByCategoryId(ProductCategoryReq req) {
        PageResponse<ProductProfileRes> data = productMange.getProductByCategoryId(req);
        return Results.success(data);
    }


    @GetMapping("/search")
    @ApiOperation(value = "根据用户搜索进行商品查询")
    public Result<PageResponse<ProductProfileRes>> searchProduct(SearchProductReq req) {
        PageResponse<ProductProfileRes> productProfileResPageResponse = productMange.searchProduct(req);
        return Results.success(productProfileResPageResponse);
    }

    @PutMapping("/modify")
    @ApiOperation(value = "修改商品信息")
    public Result<Void> updateProduct(@RequestBody Product req) {
        productMange.updateProductInfo(req);
        return Results.success();
    }

    @PutMapping("/add")
    @ApiOperation(value = "新增商品信息")
    public Result<Void> addProduct(@RequestBody Product req) {
        productMange.addProductInfo(req);
        return Results.success();
    }

    @PutMapping("/delete/{id}")
    @ApiOperation(value = "新增商品信息")
    public Result<Void> deleteProduct(@PathVariable("id")Long id) {
        productMange.deleteProductInfo(id);
        return Results.success();
    }


    @GetMapping("/recommand/{userId}")
    @ApiOperation(value = "根据用户喜好进行商品推荐")
    public Result<PageResponse<ProductProfileRes>> recommandProduct(@PathVariable("userId") String userId) {
        return null;
    }

    @PutMapping("/lock/stock")
    @ApiOperation(value = "锁定商品库存")
    public Result<Void> lockProductStock(@RequestBody OrderInfo orderInfo){
        productMange.lockProductStock(orderInfo);
        return Results.success();
    }

    @PutMapping("/unlock/stock")
    @ApiOperation(value = "释放商品库存")
    public Result<Void> unlockProductStock(@RequestBody OrderInfo orderInfo){
        productMange.unlockProductStock(orderInfo);
        return Results.success();
    }

    @PostMapping("/check/amount")
    @ApiOperation(value = "核验订单商品金额")
    public Result<CheckAmountRes> checkProductAmount(@RequestBody CheckAmountReq req){
        CheckAmountRes checkAmountRes = productMange.checkProductAmount(req);
        return Results.success(checkAmountRes);
    }

}
