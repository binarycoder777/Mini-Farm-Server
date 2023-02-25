package com.cqut.atao.farm.rocketmq.springboot.starter.message;

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

    String PAY_MESSAGE = "pay-message";

    /**
     * 支付消息发送
     *
     * @return {@link SubscribableChannel}
     */
    @Input(MessageSink.PAY_MESSAGE)
    SubscribableChannel paySend();

}
