package com.cqut.atao.farm.rocketmq.springboot.starter.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailMessageSendEvent.java
 * @Description 评论订单消息发送事件
 * @createTime 2023年01月11日 18:55:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentOrderMessageSendEvent {

    /**
     * 消息发送id
     */
    private String messageSendId;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 状态 0：成功 1：失败
     */
    private Integer status;

    /**
     * 发送时间
     */
    private Date sendTime;
}

