package com.cqut.atao.farm.product.domain.repository;

import com.cqut.atao.farm.product.domain.mode.aggregate.ProductCategory;
import com.cqut.atao.farm.product.domain.mode.vo.ProductCategoryVO;

import java.util.List;

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

    void addProductCategory(ProductCategoryVO productCategory);

    void delProductCategory(Long id);

    void updateProductCategory(ProductCategoryVO productCategory);

    List<ProductCategoryVO> ProductCategorylist();

    ProductCategoryVO productCategoryDetail(Long id);
}
