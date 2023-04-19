package com.cqut.atao.farm.order.domain.mq.consume;


import com.alibaba.fastjson.JSON;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;

import com.cqut.atao.farm.rocketmq.springboot.starter.event.CommentOrderMessageSendEvent;
import com.cqut.atao.farm.rocketmq.springboot.starter.event.PayMessageSendEvent;
import com.cqut.atao.farm.rocketmq.springboot.starter.message.MessageSink;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
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
public class MessageConsume {

    @Resource
    private OrderRepository orderRepository;

    @Transactional
    @StreamListener(MessageSink.PAY_MESSAGE)
    public void mailMessageSend(@Payload PayMessageSendEvent payMessageSendEvent, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
            String orderSn = payMessageSendEvent.getOrderSn();
            Order order = orderRepository.queryOrderInfo(orderSn);
            List<Order> subOrder = orderRepository.getSubOrder(order.getParentId());
            subOrder.stream().forEach(e -> {
                orderRepository.alterState(e.getOrderSn(), Constants.OrderState.OBLIGATEION, Constants.OrderState.WAIT_SEND);
            });
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime,
                    JSON.toJSONString(payMessageSendEvent));
        }
    }

    @Transactional
    @StreamListener(MessageSink.COMMENT_ORDER_MESSAGE)
    public void mailMessageSend(@Payload CommentOrderMessageSendEvent commentOrderMessageSendEvent, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
            orderRepository.alterState(commentOrderMessageSendEvent.getOrderSn(), Constants.OrderState.WAIT_COMMENT, Constants.OrderState.HAVE_COMMENT);
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime,
                    JSON.toJSONString(commentOrderMessageSendEvent));
        }
    }
}
