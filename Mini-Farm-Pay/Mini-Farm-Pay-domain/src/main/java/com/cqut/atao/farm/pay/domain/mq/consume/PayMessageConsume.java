package com.cqut.atao.farm.pay.domain.mq.consume;


import com.alibaba.fastjson.JSON;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate.Payment;
import com.cqut.atao.farm.pay.domain.mq.event.PayMessageSendEvent;
import com.cqut.atao.farm.pay.domain.mq.message.MessageSink;
import com.cqut.atao.farm.pay.domain.repository.PayInfoRepository;
import com.cqut.atao.farm.pay.domain.thirdpayment.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
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
    private PayInfoRepository payInfoRepository;

    @StreamListener(MessageSink.PAY_MESSAGE)
    public void mailMessageSend(@Payload PayMessageSendEvent payMessageSendEvent, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
             String paymentSn = payMessageSendEvent.getPaymentSn();
             payInfoRepository.alterPayment(paymentSn,Constants.PayState.HAVE_PAY.getCode());
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime,
                    JSON.toJSONString(payMessageSendEvent));
        }
    }
}
