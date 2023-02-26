package com.cqut.atao.farm.order.domain.service.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderEvent.java
 * @Description 订单事件基类
 * @createTime 2023年02月17日 22:24:00
 */
public abstract class OrderEvent<T> extends ApplicationEvent {

    // 携带数据
    private T data;

    public OrderEvent(Object source, T data) {
        super(source);
        this.data = data;
    }

    public OrderEvent(Object source) {
        super(source);
    }
}
