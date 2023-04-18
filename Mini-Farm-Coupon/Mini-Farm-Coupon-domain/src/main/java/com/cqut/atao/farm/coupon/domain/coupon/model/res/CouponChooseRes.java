package com.cqut.atao.farm.coupon.domain.coupon.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DiscountRes.java
 * @Description 优惠结果
 * @createTime 2023年04月18日 13:27:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponChooseRes {

    /**
     * 最优下标
     */
    private Integer choose;

    /**
     * 优惠券列表结果(可选)
     */
    private List<CouponRes> couponResList;

    /**
     * 优惠券列表结果(不可选)
     */
    private List<CouponRes> invalidResList;
}
