package com.cqut.atao.farm.coupon.domain.coupon.handler;

import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponChooser.java
 * @Description 优惠券选择器
 * @createTime 2023年04月18日 13:10:00
 */
@Component
public class CouponChooser {

    public int chooseCoupon(List<CouponRes> couponResList, BigDecimal payAmount) {
        int index = 0;
        BigDecimal current = new BigDecimal(payAmount.doubleValue());
        for (int i=0;i<couponResList.size();++i) {
            // 满减
            if (couponResList.get(i).getCouponType() == 1 && judgeFullReduction(current,payAmount,new BigDecimal(couponResList.get(i).getCouponTick()))) {
                index = i;
                current = payAmount.subtract(new BigDecimal(couponResList.get(i).getCouponTick()));
            }
            // 折扣
            if (couponResList.get(i).getCouponType() == 2 && judgeFullDiscount(current,payAmount,new BigDecimal(couponResList.get(i).getCouponTick()))) {
                index = i;
                current = payAmount.multiply(new BigDecimal(couponResList.get(i).getCouponTick())).divide(new BigDecimal(100));
            }
        }
        return index;
    }

    private boolean judgeFullDiscount(BigDecimal current, BigDecimal payAmount, BigDecimal discount) {
        return current.subtract(payAmount.multiply(discount).divide(new BigDecimal(100))).doubleValue() > 0;
    }

    private boolean judgeFullReduction(BigDecimal current,BigDecimal paymount,BigDecimal tick) {
        return paymount.subtract(tick).subtract(current).doubleValue() < 0;
    }

}
