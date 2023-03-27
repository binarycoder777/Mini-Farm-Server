package com.cqut.atao.farm.product.domain.mq.produce;

import com.alibaba.fastjson.JSON;
import com.cqut.atao.farm.product.domain.mq.event.ProductMessageSendEvent;
import com.cqut.atao.farm.rocketmq.springboot.starter.constants.MessageRocketMQConstants;
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
 * @ClassName ProductProduce.java
 * @Description 商品信息生产者
 * @createTime 2023年03月27日 10:39:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class ProductProduce {

    private final MessageChannel output;


    /**
     * 商品消息发送
     *
     * @param productMessageSendEvent
     */
    public void productMessageSend(ProductMessageSendEvent productMessageSendEvent) {
        String keys = UUID.randomUUID().toString();
        Message<?> message = MessageBuilder
                .withPayload(JSON.toJSONString(productMessageSendEvent))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, MessageRocketMQConstants.UPDATE_ES_PRODUCT_TAG)
                .build();
        long startTime = System.currentTimeMillis();
        boolean sendResult = false;
        try {
            sendResult = output.send(message, 2000L);
        } finally {
            log.info("修改商品消息发送，发送状态: {}, Keys: {}, 执行时间: {} ms, 消息内容: {}", sendResult, keys, System.currentTimeMillis() - startTime, JSON.toJSONString(productMessageSendEvent));
        }
    }

}
