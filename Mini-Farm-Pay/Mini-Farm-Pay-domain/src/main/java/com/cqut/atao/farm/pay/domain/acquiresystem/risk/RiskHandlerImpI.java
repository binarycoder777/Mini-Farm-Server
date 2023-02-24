package com.cqut.atao.farm.pay.domain.acquiresystem.risk;

import com.cqut.atao.farm.pay.domain.model.aggreate.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
/**
 * @author atao
 * @version 1.0.0
 * @ClassName RiskHandlerImpI.java
 * @Description  风险处理
 * @createTime 2023年02月24日 15:02:00
 */
@Component
@Slf4j
public class RiskHandlerImpI implements RiskHandler{

    public boolean doRisk(Order order) {
        log.info("风控处理");
        return true;
    }
}
