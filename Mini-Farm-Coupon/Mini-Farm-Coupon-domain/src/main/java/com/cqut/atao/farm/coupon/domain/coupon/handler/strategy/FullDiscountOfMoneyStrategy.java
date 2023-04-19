package com.cqut.atao.farm.coupon.domain.coupon.handler.strategy;

import com.cqut.atao.farm.coupon.domain.coupon.model.aggreate.CouponListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName FullDiscountOfNumStrategy.java
 * @Description 满多少钱打折
 * @createTime 2023年04月18日 10:32:00
 */
@Component
public class FullDiscountOfMoneyStrategy implements CouponStrategy {

    @Override
    public boolean isAccord(CouponListReq req, CouponRes res) {
        BigDecimal payAmount = req.getPayAmount();
        BigDecimal target = new BigDecimal(res.getCouponValue());
        return payAmount.subtract(target).intValue() >= 0;
    }

}
