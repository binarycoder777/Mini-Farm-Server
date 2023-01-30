package com.cqut.atao.farm.product.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductBrandPO.java
 * @Description 商品品牌
 * @createTime 2023年01月30日 16:08:00
 */
@Data
@TableName("product_brand")
public class ProductBrandPO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌介绍
     */
    @TableField("`desc`")
    private String desc;

    /**
     * 品牌图
     */
    @TableField("`pic`")
    private String pic;

    /**
     * 排序
     */
    @TableField("`sort`")
    private Integer sort;
}

