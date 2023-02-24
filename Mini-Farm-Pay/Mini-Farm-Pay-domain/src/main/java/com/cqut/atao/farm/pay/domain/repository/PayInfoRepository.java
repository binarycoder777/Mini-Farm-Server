package com.cqut.atao.farm.pay.domain.repository;

import com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate.Payment;
import com.cqut.atao.farm.pay.domain.model.aggreate.Order;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayInfoRepository.java
 * @Description 支付单仓储层接口
 * @createTime 2023年02月24日 15:22:00
 */
public interface PayInfoRepository {


    /**
     * 是否存在支付单
     * @param no 订单号
     * @return boolean
     */
    boolean isExistPayment(String no);

    /**
     * 保存支付单
     * @param payment {@link Payment}
     */
    void savePayment(Payment payment);


    /**
     * 修改支付单状态
     * @param payNo 支付单号
     * @param nextState 下一状态
     */
    void alterPayment(String payNo,Integer nextState);

}
