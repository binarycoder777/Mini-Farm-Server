package com.cqut.atao.farm.order.domain.model.aggregate;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DeliveryInfo.java
 * @Description 物流信息
 * @createTime 2023年02月27日 15:28:00
 */
public class DeliveryInfo {

    /**
     * 自动确认天数
     */
    private Integer autoConfirmDay;

    /**
     * 物流公司
     */
    private String deliveryCompany;

    /**
     * 物流单号
     */
    private String deliverySn;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 收货状态 0：未接收 1：已接收
     */
    private Integer confirmFlag;

}
