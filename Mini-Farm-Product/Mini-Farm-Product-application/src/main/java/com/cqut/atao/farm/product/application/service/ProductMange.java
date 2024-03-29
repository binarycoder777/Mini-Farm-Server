package com.cqut.atao.farm.product.application.service;

import com.cqut.atao.farm.product.application.req.CheckAmountReq;
import com.cqut.atao.farm.product.application.req.ProductCategoryReq;
import com.cqut.atao.farm.product.application.req.SearchProductReq;
import com.cqut.atao.farm.product.application.res.CheckAmountRes;
import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.application.res.ProductRes;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.req.BatchQueryReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

import java.util.List;


/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductService.java
 * @Description 商品服务接口
 * @createTime 2023年01月30日 19:23:00
 */
public interface ProductMange {

    /**
     * 根据 spuId 查询商品信息
     *
     * @param spuId 商品 SKU ID
     * @return 商品详细信息
     */
    ProductRes getProductBySpuId(Long spuId);


    /**
     * 根据categoryId分页搜索查询商品
     * @param req 请求
     * @return 结果
     */
    PageResponse<ProductProfileRes> getProductByCategoryId(ProductCategoryReq req);


    /**
     * 分页搜索查询商品
     * @param req 请求
     * @return 结果
     */
    PageResponse<ProductProfileRes> searchProduct(SearchProductReq req);

    /**
     * 锁定下单的商品库存
     * @param orderInfo {@link OrderInfo}
     */
    void lockProductStock(OrderInfo orderInfo);

    /**
     * 释放下单的商品库存
     * @param orderInfo {@link OrderInfo}
     */
    void unlockProductStock(OrderInfo orderInfo);


    /**
     * 核验订单金额
     * @param req {@link CheckAmountReq}
     * @return {@link CheckAmountRes}
     */
    CheckAmountRes checkProductAmount(CheckAmountReq req);

    /**
     * 修改商品信息
     * @param req {@link Product}
     */
    void updateProductInfo(Product req);

    List<Product> queryProducts(List<BatchQueryReq> spuIds);

    void addProductInfo(Product req);

    void deleteProductInfo(Long id);
}
