package com.cqut.atao.farm.product.test.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Sku.java
 * @Description TODO
 * @createTime 2023年03月22日 13:00:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuTest {
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
