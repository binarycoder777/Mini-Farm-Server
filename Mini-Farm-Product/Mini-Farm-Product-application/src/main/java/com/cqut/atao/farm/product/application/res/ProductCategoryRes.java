package com.cqut.atao.farm.product.application.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategoryRes.java
 * @Description 商品类别
 * @createTime 2023年01月31日 19:55:00
 */
@Data
public class ProductCategoryRes {
    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "父级ID")
    private Long parentId;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "图标URL")
    private String iconUrl;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "跳转地址")
    private String url;
}
