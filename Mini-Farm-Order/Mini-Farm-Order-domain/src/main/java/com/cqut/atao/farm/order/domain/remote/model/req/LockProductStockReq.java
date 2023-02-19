package com.cqut.atao.farm.order.domain.remote.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName LockProductStockReq.java
 * @Description 锁定商品库存请求
 * @createTime 2023年02月18日 10:51:00
 */
@Data
@Builder
public class LockProductStockReq {

    @ApiModelProperty("商品SKU集合")
    private List<Long> skuIds;

}
