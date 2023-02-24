package com.cqut.atao.farm.pay.domain.model.aggreate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderProduct.java
 * @Description 订单商品聚合类
 * @createTime 2023年02月04日 15:56:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 商品id
     */
    private Long productSkuId;

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
     * 商品购买数量
     */
    private Integer productQuantity;

    /**
     * 规格，json 格式
     */
    private String productAttribute;
}

