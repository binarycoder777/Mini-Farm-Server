package com.cqut.atao.farm.order.domain.split;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderSplitAbstract.java
 * @Description 订单拆分抽象类
 * @createTime 2023年02月26日 23:32:00
 */
public abstract class OrderSplitAbstract implements OrderSplit{

    private OrderSplitAbstract next;

    public OrderSplitAbstract(OrderSplitAbstract next) {
        this.next = next;
    }

    public OrderSplitAbstract next() {
        return next;
    }

    public OrderSplitAbstract appendNext(OrderSplitAbstract next) {
        this.next = next;
        return this;
    }

}
