package com.cqut.atao.farm.coupon.domain.activity.kill.model.req;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AddKillProductReq.java
 * @Description 添加秒杀商品请求
 * @createTime 2023年03月14日 21:13:00
 */
@Data
@Builder
public class AddKillProductReq {
    /**
     * 秒杀场次id
     */
    private Long killId;
    /**
     * 秒杀商品id
     */
    private Long productId;
    /**
     * 秒杀价格
     */
    private BigDecimal killPrice;
    /**
     * 秒杀数量
     */
    private Integer killNum;
}
