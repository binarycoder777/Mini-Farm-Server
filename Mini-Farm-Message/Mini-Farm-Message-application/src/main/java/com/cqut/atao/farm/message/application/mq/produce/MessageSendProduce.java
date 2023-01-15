package com.cqut.atao.farm.message.application.mq.produce;


import com.alibaba.fastjson2.JSON;
import com.cqut.atao.farm.message.application.mq.event.MailMessageSendEvent;
import com.cqut.atao.farm.message.common.constant.MessageRocketMQConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageSendProduce.java
 * @Description 消息发送生产者
 * @createTime 2023年01月11日 18:53:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class MessageSendProduce {

    private final MessageChannel output;

    /**
     * 邮箱消息发送
     *
     * @param mailMessageSendEvent
     */
    public void mailMessageSend(MailMessageSendEvent mailMessageSendEvent) {
        String keys = UUID.randomUUID().toString();
        Message<?> message = MessageBuilder
                .withPayload(JSON.toJSONString(mailMessageSendEvent))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, MessageRocketMQConstants.MESSAGE_MAIL_SEND_TAG)
                .build();
        long startTime = System.currentTimeMillis();
        boolean sendResult = false;
        try {
            sendResult = output.send(message, 2000L);
        } finally {
            log.info("邮箱消息发送，发送状态: {}, Keys: {}, 执行时间: {} ms, 消息内容: {}", sendResult, keys, System.currentTimeMillis() - startTime, JSON.toJSONString(mailMessageSendEvent));
        }
    }
}

