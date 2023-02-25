package com.cqut.atao.farm.pay.application.impI;

import com.cqut.atao.farm.pay.application.PayService;
import com.cqut.atao.farm.pay.domain.acquiresystem.AcquirePay;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayService.java
 * @Description 支付服务接口
 * @createTime 2023年02月24日 17:44:00
 */
@Service
public class PayServiceImpI implements PayService {

    @Resource
    private AcquirePay acquirePay;

    public void payMoney(PayReq req) {
        acquirePay.payMoneyBefore(req);
    }
}
