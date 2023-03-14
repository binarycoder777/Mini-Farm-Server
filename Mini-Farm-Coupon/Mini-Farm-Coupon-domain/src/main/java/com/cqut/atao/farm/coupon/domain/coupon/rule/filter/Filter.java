package com.cqut.atao.farm.coupon.domain.coupon.rule.filter;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Filter.java
 * @Description 过滤接口
 * @createTime 2023年03月14日 09:44:00
 */
public interface Filter {

    /**
     * 执行过滤
     */
    boolean doFilter(Long userId);

}
