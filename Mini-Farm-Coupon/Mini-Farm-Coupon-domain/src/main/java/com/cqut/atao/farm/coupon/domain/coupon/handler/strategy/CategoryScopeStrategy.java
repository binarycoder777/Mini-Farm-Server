package com.cqut.atao.farm.coupon.domain.coupon.handler.strategy;

import com.cqut.atao.farm.coupon.domain.coupon.model.aggreate.CouponListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductScopeStrategy.java
 * @Description 优惠券适用的类别范围
 * @createTime 2023年04月18日 10:37:00
 */
@Slf4j
@Component
public class CategoryScopeStrategy implements CouponStrategy{

    @Override
    public boolean isAccord(CouponListReq req, CouponRes res) {
        // todo 这里需要查redis看是否满足条件
        log.info("查看商品类型是否在优惠券范围使用范围内");
        return true;
    }

}
