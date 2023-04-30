package com.cqut.atao.farm.coupon.application.admin;

import com.cqut.atao.farm.coupon.application.admin.model.HistoryReq;
import com.cqut.atao.farm.coupon.application.admin.model.ListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.TakeCouponRecordRes;
import com.cqut.atao.farm.coupon.domain.coupon.repository.CouponRepository;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponAdmin.java
 * @Description 优惠券管理
 * @createTime 2023年04月30日 09:45:00
 */
@Service
public class CouponAdmin {

    @Resource
    private CouponRepository couponRepository;


    public PageResponse<CouponRes> couponList(ListReq req) {
        return couponRepository.couponList(req,req.getName(),req.getType());
    }

    public CouponRes couponDetail(Long id) {
        CouponRes couponRes = couponRepository.couponDetail(id);
        Long num = couponRepository.couponUseNum(couponRes.getCouponSn());
        couponRes.setUseNum(num);
        return couponRes;
    }

    public PageResponse<TakeCouponRecordRes> couponHistory(HistoryReq req) {
        return couponRepository.couponHistory(req,req.getCouponSn());
    }

    public void couponDelete(String id) {
        couponRepository.couponDelete(id);
    }
}
