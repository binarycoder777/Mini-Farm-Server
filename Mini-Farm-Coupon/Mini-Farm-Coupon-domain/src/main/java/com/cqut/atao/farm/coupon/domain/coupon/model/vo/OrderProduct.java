package com.cqut.atao.farm.coupon.domain.coupon.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderProduct.java
 * @Description 订单商品
 * @createTime 2023年04月18日 10:08:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品skuId
     */
    private Long skuId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品数量
     */
    private Integer number;

}
