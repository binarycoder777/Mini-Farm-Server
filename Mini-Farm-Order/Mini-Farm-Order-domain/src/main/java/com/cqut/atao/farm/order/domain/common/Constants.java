package com.cqut.atao.farm.order.domain.common;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Constants.java
 * @Description 枚举类
 * @createTime 2023年02月17日 14:45:00
 */
public class Constants {

    /**
     * 订单状态: 1.待付款 2.待发货 3.待签收 4.交易成功(待评价) 5.已评价 6.待退款 7.售后 8.交易关闭
     */
    public enum OrderState {

        // 订单状态码
        OBLIGATEION(1,"待付款"),
        WAIT_SEND(2,"待发货"),
        WAIT_SIGNATURE(3,"待签收"),
        WAIT_COMMENT(4,"待评价"),
        HAVE_COMMENT(5,"已评价"),
        PEND_REFUND(6,"待退款"),
        AFTER_SALE(7,"售后"),
        TRADING_CLOSED(8,"交易关闭");

        private Integer code;
        private String info;

        OrderState(Integer code, String info) {
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

        public static OrderState getStateByCode(Integer code) {
            switch (code) {
                case 1:return OBLIGATEION;
                case 2:return WAIT_SEND;
                case 3:return WAIT_SIGNATURE;
                case 4:return WAIT_COMMENT;
                case 5:return HAVE_COMMENT;
                case 6:return PEND_REFUND;
                case 7:return AFTER_SALE;
                case 8:return TRADING_CLOSED;
                default:return null;
            }
        }

        public static Integer getCodeByConstans(Enum<Constants.OrderState> state) {
            if (OrderState.OBLIGATEION.equals(state)) {
                return 1;
            } else if (OrderState.WAIT_SEND.equals(state)) {
                return 2;
            } else if (OrderState.WAIT_SIGNATURE.equals(state)) {
                return 3;
            } else if (OrderState.WAIT_COMMENT.equals(state)) {
                return 4;
            } else if (OrderState.HAVE_COMMENT.equals(state)) {
                return 5;
            } else if (OrderState.PEND_REFUND.equals(state)) {
                return 6;
            } else if (OrderState.AFTER_SALE.equals(state)) {
                return 7;
            } else if (OrderState.TRADING_CLOSED.equals(state)) {
                return 8;
            }
            return null;
        }
    }

}
