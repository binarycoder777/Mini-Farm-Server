package com.cqut.atao.farm.message.application.mq.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageSink.java
 * @Description 消息 Sink
 * @createTime 2023年01月11日 19:18:00
 */
public interface MessageSink {

    String MAIL_SEND = "mail-send";

    /**
     * 邮箱发送
     *
     * @return {@link SubscribableChannel}
     */
    @Input(MessageSink.MAIL_SEND)
    SubscribableChannel mailSend();
}
