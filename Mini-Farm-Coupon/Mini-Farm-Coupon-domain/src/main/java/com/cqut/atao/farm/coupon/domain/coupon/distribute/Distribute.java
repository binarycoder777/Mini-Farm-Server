package com.cqut.atao.farm.coupon.domain.coupon.distribute;

import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Distribute.java
 * @Description 优惠券发放接口
 * @createTime 2023年03月12日 16:18:00
 */
public interface Distribute {

    void distribute(CreateCouponReq req);

}
