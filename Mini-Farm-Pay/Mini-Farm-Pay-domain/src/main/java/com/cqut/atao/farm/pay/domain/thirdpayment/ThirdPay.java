package com.cqut.atao.farm.pay.domain.thirdpayment;


import com.cqut.atao.farm.pay.domain.model.aggreate.Order;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ThirdPay.java
 * @Description 三方支付统一接口
 * @createTime 2023年02月23日 15:05:00
 */
public interface ThirdPay {


    /**
     * 生成支付验签
     * @param order
     * @return
     */
    Object generatePaySign(Order order);


    /**
     * 通知支付结果
     * @param orderInfo
     */
    void notifyPayResult(Order orderInfo);

}
