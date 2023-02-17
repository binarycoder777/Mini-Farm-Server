package com.cqut.atao.farm.cart.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemPO.java
 * @Description 商品购物车
 * @createTime 2023年01月31日 21:21:00
 */
@Data
@TableName("cart_item")
public class CartItem extends BaseDO {

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
    private Long userId;

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
}

