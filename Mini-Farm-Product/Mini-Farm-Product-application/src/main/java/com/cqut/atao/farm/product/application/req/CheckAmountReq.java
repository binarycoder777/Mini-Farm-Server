package com.cqut.atao.farm.product.application.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CheckAmountReq.java
 * @Description 核验金额请求
 * @createTime 2023年02月18日 10:41:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckAmountReq {

    @ApiModelProperty("商品SKU集合")
    private List<Long> skuIds;

}
