package com.cqut.atao.farm.coupon.domain.coupon.common;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Constant.java
 * @Description 常量
 * @createTime 2023年04月18日 10:50:00
 */
public class Constant {

    public enum CouponFilter{
        /**
         * 优惠券筛选枚举
         */
        FULL_REDUCTION(0,"满x减y"),
        FULL_DISCOIUNT_NUM(1,"满x件打y折"),
        FULL_DISCOUNT_MONEY(2,"满x打y折"),
        PRODUCT_SCOPE(3,"适用商品范围"),
        CATEGORY_SCOPE(4,"适用类别范围");


        private Integer code;

        private String info;


        CouponFilter(Integer code, String info) {
            this.code = code;
            this.info = info;
        }
    }

}
