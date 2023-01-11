package com.cqut.atao.farm.message.application.mq.event;

import lombok.Data;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailMessageSendEvent.java
 * @Description 邮箱消息发送事件
 * @createTime 2023年01月11日 18:55:00
 */
@Data
public class MailMessageSendEvent {

    /**
     * 消息发送id
     */
    private String messageSendId;

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 标题
     */
    private String title;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    /**
     * 抄送者
     */
    private String cc;

    /**
     * 文本参数
     */
    private String paramList;

    /**
     * 状态 0：成功 1：失败
     */
    private Integer status;

    /**
     * 发送时间
     */
    private Date sendTime;
}

