package com.cqut.atao.farm.pay.domain.acquiresystem;

import com.cqut.atao.farm.pay.domain.acquiresystem.check.CheckHandler;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate.Payment;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.req.PayReq;
import com.cqut.atao.farm.pay.domain.thirdpayment.ThirdPayContent;
import com.cqut.atao.farm.pay.domain.thirdpayment.model.aggreate.Order;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AcquireAbstract.java
 * @Description 收单抽象类
 * @createTime 2023年02月23日 16:30:00
 */
public abstract class AcquireAbstract {

    @Resource
    private CheckHandler checkHandler;

    @Resource
    private ThirdPayContent thirdPayContent;

    public void payMoney(PayReq payReq){
        // 风险控制

        // 信息核验
        if (!checkHandler.doCheck(payReq.getOrder())) {
            throw  new ServiceException("信息核验出错");
        }
        // 生成支付单
        if (!isGeneratePayment(payReq.getOrder())) {
            this.generatePayment(payReq.getOrder());
        }
        // 调用三方支付进行支付
        thirdPayContent.getThirdPay(payReq.getPayCode()).doPay(payReq.getOrder());
        // MQ异步通知更新订单状态
        this.asyncUpdateOrder(payReq.getOrder());
    }

    public abstract boolean isGeneratePayment(Order order);

    public abstract Payment generatePayment(Order order);

    public abstract void asyncUpdateOrder(Order order);

}
