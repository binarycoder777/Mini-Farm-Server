package com.cqut.atao.farm.product.domain.repository;

import com.cqut.atao.farm.product.domain.mode.aggregate.ProductCategory;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategoryRepository.java
 * @Description 商品分类仓储层
 * @createTime 2023年01月31日 20:02:00
 */
public interface ProductCategoryRepository {

    /**
     * 查询所有商品分类信息
     *
     * @return
     */
    ProductCategory listAllProductCategory();

}
