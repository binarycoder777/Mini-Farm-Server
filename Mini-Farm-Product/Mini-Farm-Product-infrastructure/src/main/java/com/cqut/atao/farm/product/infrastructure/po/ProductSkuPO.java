package com.cqut.atao.farm.product.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductSkuPO.java
 * @Description 商品SKU
 * @createTime 2023年01月30日 15:57:00
 */
@Data
@TableName("product_sku")
public class ProductSkuPO  extends BaseDO {
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
