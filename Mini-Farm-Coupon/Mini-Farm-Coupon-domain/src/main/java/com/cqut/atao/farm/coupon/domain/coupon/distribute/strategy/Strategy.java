package com.cqut.atao.farm.coupon.domain.coupon.distribute.strategy;

import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Strategy.java
 * @Description 策略接口
 * @createTime 2023年03月12日 16:39:00
 */
public interface Strategy {

    /**
     * 执行策略
     * @param req 创建优惠券请求
     */
    void doStrategy(CreateCouponReq req);

}
