package com.cqut.atao.farm.order.domain.service.event;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemindDeliveryEvent.java
 * @Description 提醒发货事件
 * @createTime 2023年04月04日 15:34:00
 */
public class RemindDeliveryEvent extends OrderEvent {

    public RemindDeliveryEvent(Object source, Object data) {
        super(source, data);
    }

    public RemindDeliveryEvent(Object source) {
        super(source);
    }
}
