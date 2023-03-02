package com.cqut.atao.farm.pay.domain.acquiresystem.handler.refund;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName refund.java
 * @Description 退款接口
 * @createTime 2023年03月01日 20:37:00
 */
public interface Refund {

    Object refundMoney(String orderSn);

    Object refundMoenyResult(Object o);

}
