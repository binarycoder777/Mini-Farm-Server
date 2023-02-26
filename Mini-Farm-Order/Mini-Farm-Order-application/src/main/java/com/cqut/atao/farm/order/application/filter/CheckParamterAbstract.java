package com.cqut.atao.farm.order.application.filter;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CheckParamterAbstract.java
 * @Description 参数校验抽象类
 * @createTime 2023年02月26日 20:24:00
 */
public abstract class CheckParamterAbstract implements CheckParamter{

    private CheckParamterAbstract next;

    public CheckParamterAbstract(CheckParamterAbstract next) {
        this.next = next;
    }

    public CheckParamterAbstract next() {
        return next;
    }

    public CheckParamterAbstract appendNext(CheckParamterAbstract next) {
        this.next = next;
        return this;
    }

}
