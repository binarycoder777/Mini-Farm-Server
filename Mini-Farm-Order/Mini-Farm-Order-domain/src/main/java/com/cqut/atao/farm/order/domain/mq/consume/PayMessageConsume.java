package com.cqut.atao.farm.order.domain.mq.consume;


import com.alibaba.fastjson.JSON;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;

import com.cqut.atao.farm.rocketmq.springboot.starter.event.PayMessageSendEvent;
import com.cqut.atao.farm.rocketmq.springboot.starter.message.MessageSink;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailMessageSendConsume.java
 * @Description 支付消息消费者
 * @createTime 2023年01月11日 19:04:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class PayMessageConsume {

    @Resource
    private OrderRepository orderRepository;

    @StreamListener(MessageSink.PAY_MESSAGE)
    public void mailMessageSend(@Payload PayMessageSendEvent payMessageSendEvent, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
             String orderSn = payMessageSendEvent.getOrderSn();
             orderRepository.alterState(Long.valueOf(orderSn), Constants.OrderState.OBLIGATEION,Constants.OrderState.WAIT_SEND);
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime,
                    JSON.toJSONString(payMessageSendEvent));
        }
    }
}
