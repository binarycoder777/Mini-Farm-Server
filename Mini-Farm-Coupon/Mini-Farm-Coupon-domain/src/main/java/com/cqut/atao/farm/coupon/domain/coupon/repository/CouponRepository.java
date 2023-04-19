package com.cqut.atao.farm.coupon.domain.coupon.repository;

import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.UseCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponRepository.java
 * @Description 优惠券仓储层接口
 * @createTime 2023年03月12日 16:32:00
 */
public interface CouponRepository {

    /**
     * 创建优惠券
     * @param req {@link CreateCouponReq}
     */
    void createCoupon(CreateCouponReq req);

    /**
     * 根据优惠券id查询优惠券详情
     * @param couponSn Long
     * @return 优惠券信息
     */
    CouponRes getCoupon(String couponSn);

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

    List<CouponRes> queryInvalidCouponList(Long userId);
}
