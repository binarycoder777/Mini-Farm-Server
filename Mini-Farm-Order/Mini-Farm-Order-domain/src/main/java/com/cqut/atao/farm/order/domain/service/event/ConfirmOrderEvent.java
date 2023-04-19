package com.cqut.atao.farm.order.domain.service.event;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CancelOrderEvent.java
 * @Description 确认收货事件
 * @createTime 2023年02月17日 22:30:00
 */
public class ConfirmOrderEvent extends OrderEvent {

    public ConfirmOrderEvent(Object source, Object data) {
        super(source, data);
    }

    public ConfirmOrderEvent(Object source) {
        super(source);
    }
}
