package com.cqut.atao.farm.pay.domain.mq.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageSink.java
 * @Description 消息 Sink
 * @createTime 2023年02月24日 16:32:00
 */
public interface MessageSink {

    String PAY_MESSAGE = "pay-message";

    /**
     * 邮箱发送
     *
     * @return {@link SubscribableChannel}
     */
    @Input(MessageSink.PAY_MESSAGE)
    SubscribableChannel mailSend();

}
