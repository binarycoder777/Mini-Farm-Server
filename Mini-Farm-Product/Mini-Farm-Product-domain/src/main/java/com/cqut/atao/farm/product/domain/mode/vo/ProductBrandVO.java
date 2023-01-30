package com.cqut.atao.farm.product.domain.mode.vo;

import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductBrandVO.java
 * @Description 商品品牌
 * @createTime 2023年01月30日 19:38:00
 */
@Data
public class ProductBrandVO {

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
    private String desc;

    /**
     * 品牌图
     */
    private String pic;

    /**
     * 排序
     */
    private Integer sort;
}
