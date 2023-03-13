package com.cqut.atao.farm.coupon.domain.coupon.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName TakeCouponReq.java
 * @Description 领取优惠券请求
 * @createTime 2023年03月13日 21:47:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TakeCouponReq {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 优惠券id
     */
    private Long couponId;
    /**
     * 领取时间
     */
    private Date takeTime;
}
