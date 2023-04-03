package com.cqut.atao.farm.pay.domain.acquiresystem.handler.acquire;


import com.cqut.atao.farm.pay.domain.acquiresystem.check.CheckHandler;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate.Payment;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;
import com.cqut.atao.farm.pay.domain.acquiresystem.risk.RiskHandler;
import com.cqut.atao.farm.pay.domain.mq.produce.PayMessageProduce;
import com.cqut.atao.farm.pay.domain.repository.PayInfoRepository;
import com.cqut.atao.farm.pay.domain.thirdpayment.ThirdPayContent;
import com.cqut.atao.farm.rocketmq.springboot.starter.event.PayMessageSendEvent;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AcquireAbstract.java
 * @Description 收单抽象类
 * @createTime 2023年02月23日 16:30:00
 */
@Slf4j
public abstract class AcquireAbstract implements AcquirePay {

    @Resource
    private RiskHandler riskHandler;

    @Resource
    private CheckHandler checkHandler;

    @Resource
    private ThirdPayContent thirdPayContent;

    @Resource
    private PayMessageProduce payMessageProduce;

    @Resource
    protected PayInfoRepository payInfoRepository;

    @Override
    public Object generatePaySign(PayReq payReq) {
        // 风险控制
        if (!riskHandler.doRisk(payReq.getOrder())) {
            throw new ServiceException("该账号存在交易风险");
        }
        // 信息核验
        if (!checkHandler.doCheck(payReq.getOrder())) {
            throw new ServiceException("信息核验出错");
        }
        // 生成三方支付验签
        Object object = thirdPayContent.getThirdPay(payReq.getPayCode()).generatePaySign(payReq.getOrder());
        // 返回结果
        return object;
    }

    @Override
    public Object notifyPayResult(PayReq payReq) {
        // 三方支付成功
        if (this.paySuccess(payReq)) {
            // 生成支付单
//            Payment payment = this.generatePayment(payReq);
            // 支付结果通知
            thirdPayContent.getThirdPay(payReq.getPayCode()).notifyPayResult(payReq.getOrder());
            // 异步更新订单信息
//            this.asyncUpdateOrder(payment);
            return "pay success";
        }
        return "pay fail";
    }

    /**
     * 判断是否支付成功
     * @param req
     * @return
     */
    public abstract boolean paySuccess(PayReq req);

    /**
     * 生成支付单
     * @param payReq {@link PayReq}
     * @return {@link Payment}
     */
    public abstract Payment generatePayment(PayReq payReq);

    /**
     * 异步更新支付单和订单
     * @param payment {@link Payment}
     */
    public void asyncUpdateOrder(Payment payment) {
        log.info("异步更新订单");
        PayMessageSendEvent payMessageSendEvent = PayMessageSendEvent.builder()
                .messageSendId(UUID.randomUUID().toString())
                .orderSn(payment.getOrderSn())
                .build();
        payMessageProduce.payMessageSend(payMessageSendEvent);
    }

}
