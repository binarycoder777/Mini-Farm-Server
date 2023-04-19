package com.cqut.atao.farm.coupon.domain.activity.kill.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PassProduct.java
 * @Description TODO
 * @createTime 2023年04月11日 10:20:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassProductReq {

    /**
     * 秒杀商品记录id
     */
    private Long id;

    /**
     * 商品sku ID
     */
    private Long productSkuId;

    /**
     * 秒杀数量
     */
    private Integer num;

    /**
     * 是否通过
     */
    private boolean pass;
}
