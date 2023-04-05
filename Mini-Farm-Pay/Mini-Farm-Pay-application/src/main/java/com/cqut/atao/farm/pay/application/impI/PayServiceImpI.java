package com.cqut.atao.farm.pay.application.impI;

import com.cqut.atao.farm.pay.application.PayService;
import com.cqut.atao.farm.pay.application.req.PayResultReq;
import com.cqut.atao.farm.pay.application.req.RemitReq;
import com.cqut.atao.farm.pay.domain.acquiresystem.handler.acquire.AcquirePay;
import com.cqut.atao.farm.pay.domain.acquiresystem.handler.refund.Refund;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;
import com.cqut.atao.farm.pay.domain.clearsystem.ClearingSystem;
import com.cqut.atao.farm.pay.domain.model.aggreate.Order;
import com.cqut.atao.farm.pay.domain.remitsystem.RemitSystem;
import com.cqut.atao.farm.pay.domain.remote.RemoteOrderService;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayService.java
 * @Description 支付服务接口
 * @createTime 2023年02月24日 17:44:00
 */
@Slf4j
@Service
public class PayServiceImpI implements PayService {

    @Resource
    private AcquirePay acquirePay;

    @Resource
    private ClearingSystem clearingSystem;

    @Resource
    private RemitSystem remitSystem;

    @Resource
    private Refund refund;

    @Resource
    private RemoteOrderService remoteOrderService;

    @Override
    public Object payMoneySign(PayReq req) {
        return acquirePay.generatePaySign(req);
    }

    @Override
    public Object payMoneyResult(PayResultReq req) {
        Order orderResult = remoteOrderService.orderDetail(req.getOrderSn()).getData();
        log.info("{}",orderResult);
        orderResult.setUserId(req.getUserId());
        PayReq payReq = PayReq.builder()
                .order(orderResult)
                .payCode(req.getPayCode())
                .build();
        return acquirePay.notifyPayResult(payReq);
    }

    @Override
    public Object refundMoney(String orderSn) {
        return refund.refundMoney(orderSn);
    }

    @Override
    public Object refundMoneyResult(Object o) {
        return refund.refundMoenyResult(o);
    }


    @Override
    public void remit(RemitReq req) {
        // 清分订单
        clearingSystem.doClearing(req.getClearingHandler(),req.getData());
        // 结算
        remitSystem.remit(req.getId());
    }
}
