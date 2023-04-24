package com.cqut.atao.farm.order.domain.service.event;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UpdateAddressEvent.java
 * @Description 修改订单地址
 * @createTime 2023年04月23日 11:08:00
 */
public class UpdateAddressEvent extends OrderEvent{

    public UpdateAddressEvent(Object source, Object data) {
        super(source, data);
    }

    public UpdateAddressEvent(Object source) {
        super(source);
    }
}
