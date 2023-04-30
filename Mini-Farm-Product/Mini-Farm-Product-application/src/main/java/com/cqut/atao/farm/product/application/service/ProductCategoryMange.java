package com.cqut.atao.farm.product.application.service;

import com.cqut.atao.farm.product.application.res.ProductCategoryRes;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategoryService.java
 * @Description 商品类别服务接口
 * @createTime 2023年01月31日 19:54:00
 */
public interface ProductCategoryMange {
    /**
     * 查询全部商品分类集合
     *
     * @return
     */
    List<ProductCategoryRes> listAllProductCategory();

}
