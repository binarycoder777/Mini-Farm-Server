package com.cqut.atao.farm.pay.domain.acquiresystem.handler.refund;

import com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate.Payment;
import com.cqut.atao.farm.pay.domain.remote.RemoteOrderService;
import com.cqut.atao.farm.pay.domain.repository.PayInfoRepository;
import com.cqut.atao.farm.pay.domain.thirdpayment.Constants;
import com.cqut.atao.farm.pay.domain.thirdpayment.ThirdPayContent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RefundHandlerAbstract.java
 * @Description 退款处理器抽象类
 * @createTime 2023年03月01日 20:43:00
 */
@Slf4j
public abstract class RefundHandlerAbstract implements Refund{

    @Resource
    private ThirdPayContent thirdPayContent;

    @Resource
    private PayInfoRepository payInfoRepository;


    @Resource
    private RemoteOrderService remoteOrderService;

    public Object refundMoney(String orderSn) {
        // 根据订单号查询对应订单的支付单
        Payment payment = payInfoRepository.getPaymentByPaymentSn(orderSn);
        // 发起进行退款请求
        thirdPayContent.getThirdPay(Constants.PayType.VX.getCode()).refundMoneyReq(payment);
        return "success";
    }

    public Object refundMoenyResult(Object o) {
        if (this.judgeRefundState(o)) {
            // 支付单状态流转
            payInfoRepository.alterPayment((String)o, Constants.PayState.HAVE_REFUND.getCode());
            // 异步更新订单
            this.asyncUpdateOrder(o);
            // 异步返回优惠信息
            this.asyncReturnSpecial(o);
            return "success";
        }
        return "fails";
    }

    /**
     * 判断退款状态
     * @param o {@link Object}
     * @return boolean
     */
    public boolean judgeRefundState(Object o) {
        log.info("退款成功");
        return true;
    }

    /**
     * 更新订单状态
     * @param o
     */
    public void asyncUpdateOrder(Object o){
        log.info("异步更新订单信息");
    }

    /**
     * 返还优惠信息
     * @param o
     */
    public void asyncReturnSpecial(Object o){
        log.info("异步返回优惠信息");
    }

}
