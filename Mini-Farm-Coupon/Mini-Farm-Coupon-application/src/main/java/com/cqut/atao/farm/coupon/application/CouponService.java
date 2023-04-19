package com.cqut.atao.farm.coupon.application;

import com.cqut.atao.farm.coupon.domain.coupon.model.aggreate.CouponListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.UseCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponChooseRes;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponService.java
 * @Description 优惠券服务接口
 * @createTime 2023年03月14日 09:08:00
 */
public interface CouponService {

    /**
     * 生成优惠券
     * @param req {@link CreateCouponReq}
     */
   void generateCoupon(CreateCouponReq req);

    /**
     * 领取优惠券
     * @param req {@link TakeCouponReq}
     */
   void takeCoupon(TakeCouponReq req);

    /**
     * 获取自身优惠券分页信息
     * @param userId 用户id
     * @return {@link PageResponse}
     */
    List<CouponRes> getCouponList(Long userId);

    /**
     * 使用优惠券
     * @param req {@link UseCouponReq}
     */
    void useCoupon(UseCouponReq req);

    /**
     * 优惠选择
     * @param req
     * @return
     */
    CouponChooseRes chooseCoupon(CouponListReq req);

    CouponRes getCouponBySn(String couponSn);

    List<CouponRes> getInvalidCouponList(Long userId);
}


