package com.cqut.atao.farm.coupon.domain.coupon.rule;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RuleAbstract.java
 * @Description 规则抽象类
 * @createTime 2023年03月13日 23:12:00
 */
public abstract class RuleAbstract implements Rule{

    private Rule next;

    public RuleAbstract(Rule next) {
        this.next = next;
    }

    public Rule getNext() {
        return this.next;
    }

    public Rule appendNext(Rule rule) {
        this.next = rule;
        return this;
    }

}
