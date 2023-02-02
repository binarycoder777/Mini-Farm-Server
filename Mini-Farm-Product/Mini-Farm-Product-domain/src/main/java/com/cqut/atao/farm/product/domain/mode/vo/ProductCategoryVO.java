package com.cqut.atao.farm.product.domain.mode.vo;

import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategoryVO.java
 * @Description 商品分类
 * @createTime 2023年01月31日 20:04:00
 */
@Data
public class ProductCategoryVO {

    /**
     * id
     */
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 图标url
     */
    private String iconUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 跳转地址
     */
    private String url;

    /**
     * 状态 0：展示 1：隐藏
     */
    private Integer status;
}

