package com.cqut.atao.farm.coupon.domain.coupon.repository;

import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponRepository.java
 * @Description 领取优惠券仓储层接口
 * @createTime 2023年03月12日 16:32:00
 */
public interface TakeCouponRepository {

    /**
     * 领取优惠券
     * @param req {@link TakeCouponReq}
     */
    void takeCoupon(TakeCouponReq req);

}
