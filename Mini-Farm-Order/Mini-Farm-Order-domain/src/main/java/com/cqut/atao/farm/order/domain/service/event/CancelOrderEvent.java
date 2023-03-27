package com.cqut.atao.farm.order.domain.service.event;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CancelOrderEvent.java
 * @Description 取消订单事件
 * @createTime 2023年02月17日 22:30:00
 */
public class CancelOrderEvent extends OrderEvent {

    public CancelOrderEvent(Object source, Object data) {
        super(source, data);
    }

    public CancelOrderEvent(Object source) {
        super(source);
    }
}
