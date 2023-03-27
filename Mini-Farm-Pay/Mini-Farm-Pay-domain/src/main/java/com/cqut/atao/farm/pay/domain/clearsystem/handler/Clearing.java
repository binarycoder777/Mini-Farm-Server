package com.cqut.atao.farm.pay.domain.clearsystem.handler;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Clearing.java
 * @Description 清分接口
 * @createTime 2023年03月02日 15:25:00
 */
public interface Clearing {

    /**
     * 清分
     * @param data 订单号
     */
    void clearing(Object data);

}
