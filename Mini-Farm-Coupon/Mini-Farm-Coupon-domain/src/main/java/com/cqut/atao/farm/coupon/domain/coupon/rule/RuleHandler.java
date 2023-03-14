package com.cqut.atao.farm.coupon.domain.coupon.rule;

import com.cqut.atao.farm.coupon.domain.coupon.rule.filter.NewUserFilter;
import com.cqut.atao.farm.coupon.domain.coupon.rule.filter.RuleContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RuleHandler.java
 * @Description 规则处理器
 * @createTime 2023年03月14日 08:51:00
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleHandler extends RuleContent implements Rule{

    @Override
    public boolean doFilter(Long userId, List<Integer> ruleType) {
        for (Integer rule: ruleType) {
            boolean res = ruleGroup.get(rule).doFilter(userId);
            if (!res) {
                return false;
            }
        }
        return true;
    }

}
