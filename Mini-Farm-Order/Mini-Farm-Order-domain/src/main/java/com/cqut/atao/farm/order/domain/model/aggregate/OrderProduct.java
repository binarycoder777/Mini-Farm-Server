package com.cqut.atao.farm.order.domain.model.aggregate;

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
    private String orderId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 商品spuid
     */
    private Long productSpuId;

    /**
     * 商品skuid
     */
    private Long productSkuId;

    /**
     * 商家id
     */
    private Long merchantId;

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
     * 运费金额
     */
    private BigDecimal freightAmount;

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

    /**
     * 用户留言
     */
    private String leaveMessage;

}

