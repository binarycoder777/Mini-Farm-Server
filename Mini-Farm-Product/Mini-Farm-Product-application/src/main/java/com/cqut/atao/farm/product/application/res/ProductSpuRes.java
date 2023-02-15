package com.cqut.atao.farm.product.application.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductSpuRes.java
 * @Description 商品 SPU
 * @createTime 2023年01月31日 19:24:00
 */
@Data
public class ProductSpuRes {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("商品类型id")
    private Long categoryId;

    @ApiModelProperty("商品品牌id")
    private Long brandId;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品编码")
    private String productSn;

    @ApiModelProperty("商品主图")
    private String pic;

    @ApiModelProperty("商品图集")
    private String photoAlbum;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("促销价格")
    private BigDecimal promotionPrice;

    @ApiModelProperty("促销开始时间")
    private Date promotionStartTime;

    @ApiModelProperty("促销结束时间")
    private Date promotionEndTime;

    @ApiModelProperty("副标题")
    private String subTitle;

    @ApiModelProperty("销量")
    private Integer sales;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("商品详情")
    private String detail;

    @ApiModelProperty("发布状态 0：发布 1：未发布")
    private Integer publishStatus;

    @ApiModelProperty("新品状态 0：新品 1：非新品")
    private Integer newStatus;

    @ApiModelProperty("推荐状态 0：推荐 1：非推荐")
    private Integer recommandStatus;
}
