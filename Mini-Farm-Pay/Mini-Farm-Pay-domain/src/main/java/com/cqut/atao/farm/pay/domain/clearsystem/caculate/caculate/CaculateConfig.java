package com.cqut.atao.farm.pay.domain.clearsystem.caculate.caculate;


import com.cqut.atao.farm.pay.domain.clearsystem.caculate.rule.Rule;
import com.cqut.atao.farm.pay.domain.clearsystem.caculate.rule.impI.OrderRule;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CaculateContent.java
 * @Description 计算配置
 * @createTime 2023年03月02日 22:29:00
 */
public class CaculateConfig {

    protected static Map<String, Rule> ruleMap = new ConcurrentHashMap<>();

    @Resource
    private OrderRule orderRule;

    @PostConstruct
    public void Init() {
        ruleMap.put("orderRule",orderRule);
    }

}
