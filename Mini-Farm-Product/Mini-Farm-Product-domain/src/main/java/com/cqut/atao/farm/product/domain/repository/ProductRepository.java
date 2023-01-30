package com.cqut.atao.farm.product.domain.repository;

import com.cqut.atao.farm.product.domain.mode.aggregate.Product;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductRepository.java
 * @Description 商品仓储接口
 * @createTime 2023年01月30日 19:34:00
 */
public interface ProductRepository {

    /**
     * 根据 spuId 查询商品信息
     *
     * @param spuId
     * @return
     */
    Product getProductBySpuId(Long spuId);


}
