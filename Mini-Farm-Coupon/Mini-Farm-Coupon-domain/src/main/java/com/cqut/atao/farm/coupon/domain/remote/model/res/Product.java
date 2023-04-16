package com.cqut.atao.farm.coupon.domain.remote.model.res;

import lombok.*;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Product.java
 * @Description 商品聚合类
 * @createTime 2023年01月30日 19:37:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Product {

    /**
     * 商品品牌
     */
    private ProductBrandVO productBrand;

    /**
     * 商品 SPU
     */
    private ProductSpuVO productSpu;

    /**
     * 商品 SKU 集合
     */
    private List<ProductSkuVO> productSkus;
}

