package com.cqut.atao.farm.coupon.domain.remote.model.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductBrandRes.java
 * @Description 商品品牌
 * @createTime 2023年01月31日 19:24:00
 */
@Data
public class ProductBrandRes {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("品牌介绍")
    private String desc;

    @ApiModelProperty("品牌图")
    private String pic;

    @ApiModelProperty("排序")
    private Integer sort;

}
