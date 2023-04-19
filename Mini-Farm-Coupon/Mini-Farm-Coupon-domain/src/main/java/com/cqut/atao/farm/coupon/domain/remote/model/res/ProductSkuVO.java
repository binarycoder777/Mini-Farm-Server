package com.cqut.atao.farm.coupon.domain.remote.model.res;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductSkuVO.java
 * @Description 商品 SKU
 * @createTime 2023年01月30日 19:40:00
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductSkuVO {

    /**
     * id
     */
    @NonNull
    private Long id;

    /**
     * 商品 id
     */
    private Long productId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 锁定库存
     */
    private Integer lockStock;

    /**
     * 图片
     */
    private String pic;

    /**
     * 属性，json 格式
     */
    private String attribute;
}

