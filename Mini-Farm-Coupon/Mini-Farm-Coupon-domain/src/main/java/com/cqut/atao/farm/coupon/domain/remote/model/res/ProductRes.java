package com.cqut.atao.farm.coupon.domain.remote.model.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductResp.java
 * @Description 商品详情
 * @createTime 2023年01月30日 19:25:00
 */
@Data
public class ProductRes {

    @ApiModelProperty(value = "商品品牌")
    private ProductBrandRes productBrand;

    @ApiModelProperty(value = "商品 SPU")
    private ProductSpuRes productSpu;

    @ApiModelProperty(value = "商品 SKU")
    private List<ProductSkuRes> productSkus;

}
