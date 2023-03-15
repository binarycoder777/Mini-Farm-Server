package com.cqut.atao.farm.coupon.domain.coupon.rule.filter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName NewUserFilter.java
 * @Description 新用户规则过滤
 * @createTime 2023年03月13日 23:12:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Slf4j
public class NewUserFilter implements Filter{

    @Override
    public boolean doFilter(Long userId) {
        log.info("判断是否为新用户:{}",userId);
        return true;
    }
}
