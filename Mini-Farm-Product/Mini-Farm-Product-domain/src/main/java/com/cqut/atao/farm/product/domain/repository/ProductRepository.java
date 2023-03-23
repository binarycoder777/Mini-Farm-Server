package com.cqut.atao.farm.product.domain.repository;

import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

import java.math.BigDecimal;
import java.util.List;

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


    /**
     * 根据关键字搜索商品
     *
     * @param pageRequest {@link PageRequest}
     * @param keyword 关键字
     * @return {@link PageResponse}
     */
    PageResponse<EsProduct> searchProductInfo(PageRequest pageRequest, String keyword);


    /**
     * 根据关键字搜索商品
     *
     * @param pageRequest {@link PageRequest}
     * @param categoryId 分类Id
     * @return {@link PageResponse}
     */
    PageResponse<ProductSpuVO> searchProductByCategoryId(PageRequest pageRequest, Long categoryId);


    /**
     * 锁定下单商品库存
     * @param orderInfo {@link OrderInfo}
     */
    void lockProductStock(OrderInfo orderInfo);

    /**
     * 释放下单商品库存
     * @param orderInfo {@link OrderInfo}
     */
    void unlockProductStock(OrderInfo orderInfo);


    /**
     * 查询商品支付金额
     * @param skuList
     * @return
     */
    BigDecimal checkProductAmount(List<Long> skuList);


}
