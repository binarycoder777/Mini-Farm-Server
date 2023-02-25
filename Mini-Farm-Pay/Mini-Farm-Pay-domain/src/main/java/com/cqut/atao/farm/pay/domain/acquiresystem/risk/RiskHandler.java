package com.cqut.atao.farm.pay.domain.acquiresystem.risk;

import com.cqut.atao.farm.pay.domain.model.aggreate.Order;
/**
 * @author atao
 * @version 1.0.0
 * @ClassName RiskController.java
 * @Description 风险处理接口
 * @createTime 2023年02月24日 15:02:00
 */
public interface RiskHandler {

    boolean doRisk(Order order);

}
