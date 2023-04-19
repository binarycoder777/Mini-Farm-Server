package com.cqut.atao.farm.coupon.domain.remote.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName BatchQueryReq.java
 * @Description 批量查询请求
 * @createTime 2023年04月16日 11:53:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchQueryReq {

    private Long productId;

    private Long productSkuId;

}
