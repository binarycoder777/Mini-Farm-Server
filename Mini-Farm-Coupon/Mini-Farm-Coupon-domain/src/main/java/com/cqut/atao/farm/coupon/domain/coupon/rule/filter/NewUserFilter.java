package com.cqut.atao.farm.coupon.domain.coupon.rule.filter;

import com.cqut.atao.farm.coupon.domain.coupon.rule.Rule;
import com.cqut.atao.farm.coupon.domain.coupon.rule.RuleAbstract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName NewUserFilter.java
 * @Description 新用户规则过滤
 * @createTime 2023年03月13日 23:12:00
 */
@Component
@Slf4j
public class NewUserFilter extends RuleAbstract {

    public NewUserFilter(Rule next) {
        super(next);
    }

    @Override
    public void doFilter() {
        log.info("过滤新用户");

    }
}
