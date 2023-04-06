package com.cqut.atao.farm.product.application.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SearchProductReq.java
 * @Description 产品搜索请求(销量 > 价格 > 评论数)
 * @createTime 2023年02月11日 16:28:00
 */
@Data
public class ProductCategoryReq extends PageRequest {

    @ApiModelProperty("分类ID")
    private Long categoryId;

    @ApiModelProperty("按销量排序 0：降序 1升序")
    private Integer sortSales;

    @ApiModelProperty("按价格排序 0：降序 1升序")
    private Integer sortPrice;

}
