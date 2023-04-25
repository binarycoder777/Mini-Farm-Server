package com.cqut.atao.farm.order.application.record;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Operate.java
 * @Description TODO
 * @createTime 2023年04月25日 14:47:00
 */
public interface Operate {

    void doOperate(String orderSn,Integer eventType,String note);

}
