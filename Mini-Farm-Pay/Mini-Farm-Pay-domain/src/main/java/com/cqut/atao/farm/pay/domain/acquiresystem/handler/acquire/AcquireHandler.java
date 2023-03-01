package com.cqut.atao.farm.pay.domain.acquiresystem.handler.acquire;


import com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate.Payment;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;
import com.cqut.atao.farm.pay.domain.thirdpayment.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AcquireHandler.java
 * @Description 收单处理
 * @createTime 2023年02月23日 20:21:00
 */
@Component
@Slf4j
public class AcquireHandler extends AcquireAbstract {

    @Override
    public Payment generatePayment(PayReq req) {
        log.info("生成支付单");
        String payno = UUID.randomUUID().toString();
        Payment payment = Payment.builder()
                .orderSn(req.getOrder().getOrderSn())
                .totalAmount(req.getOrder().getTotalAmount())
                .freightAmount(req.getOrder().getFreightAmount())
                .payAmount(req.getOrder().getPayAmount())
                .userId(req.getOrder().getUserId())
                .payType(req.getPayCode())
                .status(Constants.PayState.HAVE_PAY.getCode())
                .paySn(payno)
                .payTime(new Date())
                .build();
        payInfoRepository.savePayment(payment);
        return payment;
    }

    @Override
    public boolean paySuccess(PayReq req) {
        log.info("支付成功");
        return true;
    }
}
