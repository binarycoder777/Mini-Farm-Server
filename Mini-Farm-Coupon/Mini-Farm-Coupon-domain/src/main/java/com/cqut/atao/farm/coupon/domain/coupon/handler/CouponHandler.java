package com.cqut.atao.farm.coupon.domain.coupon.handler;

import com.cqut.atao.farm.coupon.domain.coupon.model.aggreate.CouponListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponChooseRes;
import com.cqut.atao.farm.coupon.domain.coupon.repository.CouponRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponHandler.java
 * @Description 优惠券处理（根据前端上传的订单商品数据，过滤掉无法使用的优惠券，同时选出最优优惠券组合）
 * @createTime 2023年04月18日 11:11:00
 */
@Component
public class CouponHandler {

    @Resource
    private CouponRepository couponRepository;

    @Resource
    private InvalidCouponHandler invalidCouponHandler;

    @Resource
    private CouponChooser couponChooser;

    public CouponChooseRes doCoupon(CouponListReq req) {
        // 用户自身的优惠券
        List<CouponRes> couponResList = couponRepository.getCouponList(req.getUserId());
        // 过滤掉本次订单中不能使用的优惠券
        List<List<CouponRes>> lists = invalidCouponHandler.doFilt(req, couponResList);
        // 进行优惠券最优组合
        int index = couponChooser.chooseCoupon(lists.get(0), req.getPayAmount());
        // 返回优惠结果
        return CouponChooseRes.builder()
                .choose(index)
                .couponResList(lists.get(0))
                .invalidResList(lists.get(1))
                .build();
    }

}
