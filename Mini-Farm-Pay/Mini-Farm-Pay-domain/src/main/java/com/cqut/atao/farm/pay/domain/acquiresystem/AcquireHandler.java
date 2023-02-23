package com.cqut.atao.farm.pay.domain.acquiresystem;

import com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate.Payment;
import com.cqut.atao.farm.pay.domain.thirdpayment.model.aggreate.Order;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AcquireHandler.java
 * @Description 收单处理
 * @createTime 2023年02月23日 20:21:00
 */
public class AcquireHandler extends AcquireAbstract{

    @Override
    public boolean isGeneratePayment(Order order) {
        return false;
    }

    @Override
    public Payment generatePayment(Order order) {
        return null;
    }

    @Override
    public void asyncUpdateOrder(Order order) {

    }
}
