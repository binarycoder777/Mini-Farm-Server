package com.cqut.atao.farm.order.application.filter.check;

import com.cqut.atao.farm.order.application.filter.CheckParamterAbstract;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.PlaceOrderReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CheckNullParmter.java
 * @Description 校验空参数
 * @createTime 2023年02月26日 21:51:00
 */
@Slf4j
@Component
public class CheckNullParmter extends CheckParamterAbstract {

    public CheckNullParmter(CheckParamterAbstract next) {
        super(next);
    }

    @Override
    public boolean doCheck(PlaceOrderReq order) {
        log.info("空参数校验");
        if (next() == null) {
            return true;
        }
        return next().doCheck(order);
    }
}
