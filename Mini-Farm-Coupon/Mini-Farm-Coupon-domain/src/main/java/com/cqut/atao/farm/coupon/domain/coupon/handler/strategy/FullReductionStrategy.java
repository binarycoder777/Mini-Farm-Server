package com.cqut.atao.farm.coupon.domain.coupon.handler.strategy;

import com.cqut.atao.farm.coupon.domain.coupon.model.aggreate.CouponListReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName FullReductionStrategy.java
 * @Description 满减策略（支付金额 - 满减值 >= 0 则符合条件）
 * @createTime 2023年04月18日 10:26:00
 */
@Slf4j
@Component
public class FullReductionStrategy implements CouponStrategy{

    @Override
    public boolean isAccord(CouponListReq req, CouponRes res) {
         BigDecimal payAmount = req.getPayAmount();
         BigDecimal target = new BigDecimal(res.getCouponValue());
         return payAmount.subtract(target).intValue() >= 0;
    }
}
