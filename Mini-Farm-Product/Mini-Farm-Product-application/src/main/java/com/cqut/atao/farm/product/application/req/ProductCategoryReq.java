package com.cqut.atao.farm.product.application.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SearchProductReq.java
 * @Description 产品搜索请求
 * @createTime 2023年02月11日 16:28:00
 */
@Data
public class ProductCategoryReq extends PageRequest {

    @ApiModelProperty("分类ID")
    private Long categoryId;

}
