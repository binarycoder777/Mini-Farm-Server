package com.cqut.atao.farm.product.domain.mq.messaging;

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

    String PRODUCT_SEND = "product-send";

    /**
     * 商品信息发送
     *
     * @return {@link SubscribableChannel}
     */
    @Input(MessageSink.PRODUCT_SEND)
    SubscribableChannel productSend();
}
