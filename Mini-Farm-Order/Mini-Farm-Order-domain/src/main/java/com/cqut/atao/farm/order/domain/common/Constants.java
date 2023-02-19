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
    }

}
