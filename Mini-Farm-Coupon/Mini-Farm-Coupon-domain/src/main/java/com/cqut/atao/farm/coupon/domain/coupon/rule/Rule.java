package com.cqut.atao.farm.coupon.domain.coupon.rule;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Rule.java
 * @Description 优惠券规则接口
 * @createTime 2023年03月13日 23:02:00
 */
public interface Rule {

    boolean doFilter(Long userId,List<Integer> ruleType);

}
