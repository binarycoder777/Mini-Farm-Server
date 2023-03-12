package com.cqut.atao.farm.coupon.domain.coupon.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateCouponReq.java
 * @Description 创建优惠券请求
 * @createTime 2023年03月12日 16:20:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCouponReq {

    /**
     * 优惠券名字
     */
    private String couponName;
    /**
     * 优惠券面额
     */
    private Long couponValue;
    /**
     * 优惠券数量
     */
    private Long couponNum;
    /**
     * 发放时间
     */
    private Date distributeTime;
    /**
     * 有效期限
     */
    private Date validityTime;

}
