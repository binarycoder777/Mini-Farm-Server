package com.cqut.atao.farm.coupon.domain.coupon.distribute;

import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.UseCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Distribute.java
 * @Description 优惠券发放接口
 * @createTime 2023年03月12日 16:18:00
 */
public interface Distribute {

    /**
     * 优惠券发放
     * @param req {@link CreateCouponReq}
     */
    void distribute(CreateCouponReq req);

    /**
     * 领取优惠券
     * @param req {@link TakeCouponReq}
     */
    void takeCoupon(TakeCouponReq req);

    /**
     * 获取优惠券列表
     * @param userId 用户id
     * @return {@link List}
     */
    List<CouponRes> getCouponList(Long userId);

    /**
     * 使用优惠券
     * @param req {@link UseCouponReq}
     */
    void useCoupon(UseCouponReq req);
}
