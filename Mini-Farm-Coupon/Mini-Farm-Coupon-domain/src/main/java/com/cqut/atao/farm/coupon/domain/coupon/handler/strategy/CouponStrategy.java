package com.cqut.atao.farm.coupon.domain.coupon.handler.strategy;

import com.cqut.atao.farm.coupon.domain.coupon.model.aggreate.CouponListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponStrategy.java
 * @Description 优惠券筛选策略
 * @createTime 2023年04月18日 10:27:00
 */
public interface CouponStrategy {

    /**
     * 是否符合优惠券适用条件
     * @param req
     * @param res
     * @return
     */
    boolean isAccord(CouponListReq req, CouponRes res);

}
