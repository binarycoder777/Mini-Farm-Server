package com.cqut.atao.farm.order.domain.event;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CreateOrderEvent.java
 * @Description 创建订单事件
 * @createTime 2023年02月17日 22:23:00
 */
public class CreateOrderEvent extends OrderEvent{


    public CreateOrderEvent(Object source, Object data) {
        super(source, data);
    }

    public CreateOrderEvent(Object source) {
        super(source);
    }
}
