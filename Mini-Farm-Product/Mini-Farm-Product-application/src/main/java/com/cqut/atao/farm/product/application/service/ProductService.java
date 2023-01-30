package com.cqut.atao.farm.product.application.service;

import com.cqut.atao.farm.product.application.res.ProductRes;


/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductService.java
 * @Description 商品服务接口
 * @createTime 2023年01月30日 19:23:00
 */
public interface ProductService {

    /**
     * 根据 spuId 查询商品信息
     *
     * @param spuId 商品 SKU ID
     * @return 商品详细信息
     */
    ProductRes getProductBySpuId(Long spuId);

}
