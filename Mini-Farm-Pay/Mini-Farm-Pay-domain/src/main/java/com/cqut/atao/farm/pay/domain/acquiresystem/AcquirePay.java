package com.cqut.atao.farm.pay.domain.acquiresystem;

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
     * 付款
     * @param payReq 支付请求
     */
    void payMoney(PayReq payReq);

}
