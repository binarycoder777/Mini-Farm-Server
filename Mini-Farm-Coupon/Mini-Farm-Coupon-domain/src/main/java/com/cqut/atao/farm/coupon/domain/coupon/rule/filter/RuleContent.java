package com.cqut.atao.farm.coupon.domain.coupon.rule.filter;

import com.cqut.atao.farm.coupon.domain.common.Constant;
import com.cqut.atao.farm.coupon.domain.coupon.rule.Rule;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ConcurrentMap;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RuleContent.java
 * @Description 规则上下文
 * @createTime 2023年03月14日 09:33:00
 */
@Component
public class RuleContent {

    @Resource
    private NewUserFilter newUserFilter;

    protected ConcurrentMap<Integer, Filter> ruleGroup = Maps.newConcurrentMap();

    @PostConstruct
    public void Init() {
        ruleGroup.put(Constant.RULE_TYPE.NEW_USER.getCode(),newUserFilter);
    }

}
