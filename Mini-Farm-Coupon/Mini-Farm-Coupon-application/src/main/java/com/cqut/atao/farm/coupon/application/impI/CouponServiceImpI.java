package com.cqut.atao.farm.coupon.application.impI;

import com.cqut.atao.farm.coupon.application.CouponService;
import com.cqut.atao.farm.coupon.domain.coupon.distribute.Distribute;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponServiceImpI.java
 * @Description 优惠券服务接口实现
 * @createTime 2023年03月14日 09:08:00
 */
public class CouponServiceImpI implements CouponService {

    @Resource
    private Distribute distributeCoupon;

    @Override
    public void generateCoupon(CreateCouponReq req) {
        distributeCoupon.distribute(req);
    }

    @Override
    public void takeCoupon(TakeCouponReq req) {
        distributeCoupon.takeCoupon(req);
    }

    @Override
    public List<CouponRes> getCouponList(Long userId) {
        return distributeCoupon.getCouponList(userId);
    }
}
