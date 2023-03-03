package com.cqut.atao.farm.pay.application.impI;

import com.cqut.atao.farm.pay.application.PayService;

import com.cqut.atao.farm.pay.application.req.RemitReq;
import com.cqut.atao.farm.pay.domain.acquiresystem.handler.acquire.AcquirePay;
import com.cqut.atao.farm.pay.domain.acquiresystem.handler.refund.Refund;
import com.cqut.atao.farm.pay.domain.acquiresystem.handler.refund.RefundHandler;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;
import com.cqut.atao.farm.pay.domain.clearsystem.ClearingSystem;
import com.cqut.atao.farm.pay.domain.clearsystem.common.Constants;
import com.cqut.atao.farm.pay.domain.remitsystem.RemitSystem;
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

    @Resource
    private ClearingSystem clearingSystem;

    @Resource
    private RemitSystem remitSystem;

    @Resource
    private Refund refund;

    public Object payMoneySign(PayReq req) {
        return acquirePay.generatePaySign(req);
    }

    public Object payMoneyResult(PayReq req) {
        return acquirePay.notifyPayResult(req);
    }

    public Object refundMoney(String orderSn) {
        return refund.refundMoney(orderSn);
    }

    public Object refundMoneyResult(Object o) {
        return refund.refundMoenyResult(o);
    }


    public void remit(RemitReq req) {
        // 清分订单
        clearingSystem.doClearing(req.getClearingHandler(),req.getData());
        // 结算
        remitSystem.remit(req.getId());
    }
}
