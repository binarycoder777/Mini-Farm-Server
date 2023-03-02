package com.cqut.atao.farm.pay.domain.clearsystem;

import com.cqut.atao.farm.pay.domain.clearsystem.common.Constants;
import com.cqut.atao.farm.pay.domain.clearsystem.handler.Clearing;
import com.cqut.atao.farm.pay.domain.clearsystem.handler.impI.OrderClearingHandler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ClearingConfig.java
 * @Description 清分配置类
 * @createTime 2023年03月02日 23:20:00
 */
public class ClearingConfig {
    @Resource
    private OrderClearingHandler orderClearingHandler;

    protected static Map<Constants.ClearingHandler, Clearing> clearingHandlerMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void Init() {
        clearingHandlerMap.put(Constants.ClearingHandler.ORDER,orderClearingHandler);
    }

}
