package com.cqut.atao.farm.coupon.domain.coupon.handler;

import com.cqut.atao.farm.coupon.domain.coupon.common.Constant;
import com.cqut.atao.farm.coupon.domain.coupon.handler.strategy.StrategyContent;
import com.cqut.atao.farm.coupon.domain.coupon.model.aggreate.CouponListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName FilterInvalidCoupon.java
 * @Description 过滤无效的优惠券
 * @createTime 2023年04月18日 10:22:00
 */
@Slf4j
@Component
public class InvalidCouponHandler {

    @Resource
    private StrategyContent strategyContent;

    /**
     * 过滤当前订单中不能使用的优惠券
     * @return
     */
    public List<List<CouponRes>> doFilt(CouponListReq req, List<CouponRes> couponResList) {
        List<CouponRes> valid = Lists.newArrayList();
        List<CouponRes> invalid = Lists.newArrayList();
        for (int i=0;i<couponResList.size();++i) {
            CouponRes couponRes = couponResList.get(i);
            // 不满足指定商品能使用
            if (couponRes.getCouponScope() == 1 && !strategyContent.group.get(Constant.CouponFilter.PRODUCT_SCOPE).isAccord(req,couponRes)) {
                invalid.add(couponRes);
                continue;
            }
            // 不满足指定类别使用
            if (couponRes.getCouponScope() == 2 && !strategyContent.group.get(Constant.CouponFilter.CATEGORY_SCOPE).isAccord(req,couponRes)) {
                invalid.add(couponRes);
                continue;
            }
            // 不满足满减条件
            if (couponRes.getCouponType() == 1 && !strategyContent.group.get(Constant.CouponFilter.FULL_REDUCTION).isAccord(req,couponRes)) {
                invalid.add(couponRes);
                continue;
            }
            // 不满足满折条件
            if (couponRes.getCouponType() == 2 && !strategyContent.group.get(Constant.CouponFilter.FULL_DISCOIUNT_NUM).isAccord(req,couponRes)) {
                invalid.add(couponRes);
                continue;
            }
            // 满足上述条件，则为可使用的优惠券
            valid.add(couponRes);
        }
        List<List<CouponRes>> res = Lists.newArrayList();
        res.add(valid);
        res.add(invalid);
        return res;
    }

}
