package com.cqut.atao.farm.coupon.domain.coupon.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName TakeCoupon.java
 * @Description 领取优惠券记录类
 * @createTime 2023年03月13日 21:44:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakeCouponRecordRes {

    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 优惠券sn
     */
    private String couponSn;
    /**
     * 领取时间
     */
    private Date takeTime;
    /**
     * 订单号
     */
    private String orderSn;
    /**
     * 使用状态[0->未使用；1->已使用；2->已过期]
     */
    private Integer useStatus;

    private Date createTime;

}
