package com.cqut.atao.farm.pay.domain.clearsystem.caculate.caculate.impI;

import com.cqut.atao.farm.pay.domain.clearsystem.caculate.caculate.Caculator;
import com.cqut.atao.farm.pay.domain.clearsystem.common.Constants;
import com.cqut.atao.farm.pay.domain.model.res.ClearingRecordRes;
import com.cqut.atao.farm.pay.domain.remote.model.res.OrderInfoRes;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DefaultCaculator.java
 * @Description 默认的规则计算器(直接生成农户、平台的清算记录)
 * @createTime 2023年03月02日 22:16:00
 */
@Component
public class DefaultCaculator extends Caculator {

    // 这里暂时固定写
    @Override
    public List<ClearingRecordRes> process(Object model, Object rule, Object data) {
        OrderInfoRes orderInfoRes = (OrderInfoRes) data;
        // 获取支付金额
        BigDecimal payAmount = orderInfoRes.getPayAmount();
        // 农户分账支付金额95%
        BigDecimal farmAmount = payAmount.multiply(new BigDecimal("0.95"));
        // 平台分账支付金额5%
        BigDecimal platformAmount = payAmount.multiply(new BigDecimal("0.05"));
        // 构建清分记录
        List<ClearingRecordRes> list = new ArrayList<>();
        list.add(build(farmAmount,orderInfoRes.getUserId()));
        list.add(build(platformAmount,orderInfoRes.getUserId()));
        return list;
    }

    /**
     * 构建清分记录
     * @param amount
     * @param clearUserId
     * @return
     */
    public ClearingRecordRes build(BigDecimal amount,Long clearUserId) {
        return ClearingRecordRes.builder()
                .clearSn(ClearingRecordRes.generateClearingSn())
                .clearType(Constants.ClearingHandler.ORDER.getCode())
                .totalAmount(amount)
                .clearUserId(clearUserId)
                .build();
    }
}
