package com.cqut.atao.farm.pay.application;

import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayService.java
 * @Description 支付服务接口
 * @createTime 2023年02月24日 17:44:00
 */
public interface PayService {

    /**
     * 付款
     * @param req 支付请求
     */
    void payMoney(PayReq req);

}
