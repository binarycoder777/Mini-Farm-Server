package com.cqut.atao.farm.order.application.filter;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CheckParamter.java
 * @Description 参数校验接口
 * @createTime 2023年02月26日 20:21:00
 */
public interface CheckParamter {


    /**
     * 执行订单参数校验
     * @param order {@link Order}
     * @return boolean
     */
    boolean doCheck(Order order);

}
