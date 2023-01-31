package com.cqut.atao.farm.cart.domain.mode.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItem.java
 * @Description 购物车
 * @createTime 2023年01月31日 21:48:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    /**
     * id
     */
    private Long id;

    /**
     * 商品 spu id
     */
    private Long productId;

    /**
     * 商品 sku id
     */
    private Long productSkuId;

    /**
     * c 端用户 id
     */
    private Long customerUserId;

    /**
     * 商品图
     */
    private String productPic;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品品牌
     */
    private String productBrand;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 加购物车数量
     */
    private Integer productQuantity;

    /**
     * 商品规格，json 格式
     */
    private String productAttribute;

    /**
     * 选中标志
     */
    private Integer selectFlag;

    /**
     * 商品 sku ids
     */
    private List<String> skuIds;
}
