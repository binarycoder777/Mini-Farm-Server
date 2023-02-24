package com.cqut.atao.farm.pay.domain.mq.produce;



import com.alibaba.fastjson.JSON;
import com.cqut.atao.farm.pay.domain.mq.MessageRocketMQConstants;
import com.cqut.atao.farm.pay.domain.mq.event.PayMessageSendEvent;
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
 * @Description 支付消息生产者
 * @createTime 2023年01月11日 18:53:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class PayMessageProduce {

    private final MessageChannel output;

    /**
     * 邮箱消息发送
     *
     * @param payMessageSendEvent
     */
    public void mailMessageSend(PayMessageSendEvent payMessageSendEvent) {
        String keys = UUID.randomUUID().toString();
        Message<?> message = MessageBuilder
                .withPayload(JSON.toJSONString(payMessageSendEvent))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, MessageRocketMQConstants.MESSAGE_PAY_SEND_TAG)
                .build();
        long startTime = System.currentTimeMillis();
        boolean sendResult = false;
        try {
            sendResult = output.send(message, 2000L);
        } finally {
            log.info("支付消息发送，发送状态: {}, Keys: {}, 执行时间: {} ms, 消息内容: {}", sendResult, keys, System.currentTimeMillis() - startTime, JSON.toJSONString(payMessageSendEvent));
        }
    }
}

