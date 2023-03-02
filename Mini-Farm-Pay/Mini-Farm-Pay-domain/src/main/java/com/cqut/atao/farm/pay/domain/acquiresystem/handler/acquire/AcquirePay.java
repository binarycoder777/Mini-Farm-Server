package com.cqut.atao.farm.pay.domain.acquiresystem.handler.acquire;

import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AcquirePay.java
 * @Description 收单支付接口
 * @createTime 2023年02月24日 09:36:00
 */
public interface AcquirePay {

    /**
     * 付款前，生成三方支付验签
     * @param payReq 支付请求
     */
    Object generatePaySign(PayReq payReq);

    /**
     * 通知三方支付结果
     * @param payReq 支付请求
     */
    Object notifyPayResult(PayReq payReq);

}
