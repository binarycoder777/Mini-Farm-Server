package com.cqut.atao.farm.pay.domain.thirdpayment;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Constants.java
 * @Description 常量
 * @createTime 2023年02月23日 15:19:00
 */
public class Constants {

    public enum PayType{

        // 微信支付
        VX(0,"微信支付");

        private Integer code;

        private String info;

        PayType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public enum PayState{
        // 1.未支付 2.已支付
        UN_PAY(1,"未支付"),
        HAVE_PAY(2,"已支付"),
        HAVE_REFUND(3,"已退款");
        private Integer code;
        private String info;

        PayState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


}
