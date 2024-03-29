package com.cqut.atao.farm.coupon.application.impI;

import com.cqut.atao.farm.coupon.application.CouponService;
import com.cqut.atao.farm.coupon.domain.coupon.distribute.Distribute;
import com.cqut.atao.farm.coupon.domain.coupon.handler.CouponHandler;
import com.cqut.atao.farm.coupon.domain.coupon.model.aggreate.CouponListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.UseCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponChooseRes;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponServiceImpI.java
 * @Description 优惠券服务接口实现
 * @createTime 2023年03月14日 09:08:00
 */
@Service
public class CouponServiceImpI implements CouponService {

    @Resource
    private Distribute distributeCoupon;

    @Resource
    private CouponHandler couponHandler;

    @Override
    public void generateCoupon(CreateCouponReq req) {
        distributeCoupon.distribute(req);
    }

    @Override
    public void takeCoupon(TakeCouponReq req) {
        req.setTakeTime(new Date());
        distributeCoupon.takeCoupon(req);
    }

    @Override
    public List<CouponRes> getCouponList(Long userId) {
        return distributeCoupon.getCouponList(userId);
    }

    @Override
    public void useCoupon(UseCouponReq req) {
        distributeCoupon.useCoupon(req);
    }

    @Override
    public CouponChooseRes chooseCoupon(CouponListReq req) {
        return couponHandler.doCoupon(req);
    }

    @Override
    public CouponRes getCouponBySn(String couponSn) {
        return distributeCoupon.queryCoupon(couponSn);
    }

    @Override
    public List<CouponRes> getInvalidCouponList(Long userId) {
        return distributeCoupon.queryInvalidCouponList(userId);
    }

    @Override
    public void updateCoupon(CreateCouponReq req) {
        distributeCoupon.updateCoupon(req);
    }
}
