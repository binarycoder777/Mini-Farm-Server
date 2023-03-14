package com.cqut.atao.farm.coupon.domain.common;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Constant.java
 * @Description 常量类
 * @createTime 2023年03月13日 17:34:00
 */
public class Constant {

    /**
     * 优惠券发放规则类型
     */
    public enum RULE_TYPE {
        // 新用户专享
        NEW_USER(0),
        // 消费满x元赠送
        COMSUME(1);
        private Integer code;

        RULE_TYPE(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

    /**
     * 优惠券发放类型
     */
    public enum DISTRBUT_TYPE {
        // 系统发放
        SYSTEM(0),
        // 管理员发放
        ADMIN(1),
        // 用户领取
        TAKE(2);
        private Integer code;

        DISTRBUT_TYPE(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

    /**
     * 优惠券适用商品选中
     */
    public enum COUPON_SCOPE {
        // 所有商品
        ALL(0),
        // 指定商品
        SPECIAL_PRODUCT(1),
        // 指定类型
        SPECIAL_TYPE(2);

        private Integer code;

        COUPON_SCOPE(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

    /**
     * 优惠券发放对象选择
     */
    public enum DISTRBUT_OBJECT {
        // 所有人发放
        ALL(0),
        // 筛选人发放
        SCREENING(1);
        private Integer code;

        DISTRBUT_OBJECT(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

}
