package com.cqut.atao.farm.order.domain.stateflow;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.stateflow.state.*;

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

    @Resource
    private WaitSendState waitSendState;

    @Resource
    private WaitSginState waitSginState;

    @Resource
    private WaitCommentState waitCommentState;

    @Resource
    private PendRefundState pendRefundState;

    @Resource
    private AfterSaleState afterSaleState;



    protected Map<Enum<Constants.OrderState>, AbstractState> stateMap = new ConcurrentHashMap<Enum<Constants.OrderState>, AbstractState>();

    @PostConstruct
    public void init() {
        stateMap.put(Constants.OrderState.OBLIGATEION,obligationState);
        stateMap.put(Constants.OrderState.WAIT_SEND,waitSendState);
        stateMap.put(Constants.OrderState.WAIT_SIGNATURE,waitSginState);
        stateMap.put(Constants.OrderState.WAIT_COMMENT,waitCommentState);
        stateMap.put(Constants.OrderState.PEND_REFUND,pendRefundState);
        stateMap.put(Constants.OrderState.AFTER_SALE,afterSaleState);
    }

}
