package com.cqut.atao.farm.product.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategoryPO.java
 * @Description 商品分类
 * @createTime 2023年01月30日 16:06:00
 */
@Data
@TableName("product_category")
public class ProductCategoryPO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
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

