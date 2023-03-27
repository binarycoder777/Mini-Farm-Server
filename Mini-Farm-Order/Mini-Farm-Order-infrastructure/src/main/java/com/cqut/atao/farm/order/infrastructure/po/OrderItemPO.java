package com.cqut.atao.farm.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderItemPO.java
 * @Description 订单商品详情类
 * @createTime 2023年02月04日 15:04:00
 */
@Data
@TableName("order_item")
public class OrderItemPO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 商品sku id
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
