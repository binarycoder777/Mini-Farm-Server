package com.cqut.atao.farm.rocketmq.springboot.starter.event;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailMessageSendEvent.java
 * @Description 支付消息发送事件
 * @createTime 2023年01月11日 18:55:00
 */
@Data
@Builder
public class ReturnSpecialMessageSendEvent {

    /**
     * 消息发送id
     */
    private String messageSendId;

    /**
     * 活动id
     */
    private Long acitivityId;

    /**
     * 优惠卷id
     */
    private Long couponId;

    /**
     * 状态 0：成功 1：失败
     */
    private Integer status;

    /**
     * 发送时间
     */
    private Date sendTime;
}

