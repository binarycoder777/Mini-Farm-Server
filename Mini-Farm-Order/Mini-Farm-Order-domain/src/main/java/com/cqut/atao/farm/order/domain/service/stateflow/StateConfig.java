package com.cqut.atao.farm.order.domain.service.stateflow;

import com.cqut.atao.farm.order.domain.service.stateflow.state.ObligationState;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName StateConfig.java
 * @Description 状态流转配置类
 * @createTime 2023年02月17日 14:34:00
 */
public class StateConfig {

    @Resource
    private ObligationState obligationState;

    protected Map<Enum<Constants.OrderState>,AbstractState> stateMap = new ConcurrentHashMap<Enum<Constants.OrderState>, AbstractState>();

    @PostConstruct
    public void init() {
        stateMap.put(Constants.OrderState.OBLIGATEION,obligationState);
    }

}
