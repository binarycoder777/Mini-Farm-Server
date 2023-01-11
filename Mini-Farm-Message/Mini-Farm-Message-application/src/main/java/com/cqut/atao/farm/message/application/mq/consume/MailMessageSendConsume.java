package com.cqut.atao.farm.message.application.mq.consume;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.cqut.atao.farm.message.application.mq.event.MailMessageSendEvent;
import com.cqut.atao.farm.message.application.mq.messaging.MessageSink;
import com.cqut.atao.farm.message.domain.email.model.req.MailMessageSendReq;
import com.cqut.atao.farm.message.domain.email.service.MailMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailMessageSendConsume.java
 * @Description 邮箱消息发送消费者
 * @createTime 2023年01月11日 19:04:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class MailMessageSendConsume {

    private final MailMessageService mailMessageService;

    @StreamListener(MessageSink.MAIL_SEND)
    public void mailMessageSend(@Payload MailMessageSendEvent mailMessageSendEvent, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
            // 1.构建信息
            MailMessageSendReq req = BeanUtil.toBean(mailMessageSendEvent, MailMessageSendReq.class);
            // 2.发送邮件
            boolean sendResult = mailMessageService.send(req);
            // 3.信息记录落库
            req.setSendResult(sendResult);
            mailMessageService.saveMailMessage(req);
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime,
                    JSON.toJSONString(mailMessageSendEvent));
        }
    }
}
