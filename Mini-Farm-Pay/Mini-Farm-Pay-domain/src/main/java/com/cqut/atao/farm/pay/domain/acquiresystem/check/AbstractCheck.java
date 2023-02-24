package com.cqut.atao.farm.pay.domain.acquiresystem.check;

import com.cqut.atao.farm.pay.domain.model.aggreate.Order;
/**
 * @author atao
 * @version 1.0.0
 * @ClassName AbstractCheck.java
 * @Description 抽象核验类
 * @createTime 2023年02月23日 19:15:00
 */
public abstract class AbstractCheck {

    private AbstractCheck next;

    public AbstractCheck() {
    }

    public AbstractCheck(AbstractCheck next) {
        this.next = next;
    }

    public AbstractCheck next() {
        return next;
    }

    public AbstractCheck appendNext(AbstractCheck next) {
        this.next = next;
        return this;
    }

    public abstract boolean doCheck(Order order);

}
