package com.cqut.atao.farm.message.application.service.impI;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.cqut.atao.farm.message.application.mq.event.MailMessageSendEvent;
import com.cqut.atao.farm.message.application.mq.produce.MessageSendProduce;
import com.cqut.atao.farm.message.application.service.SendMessageService;
import com.cqut.atao.farm.message.domain.email.model.aggregates.MailMessageSendAggregates;
import com.cqut.atao.farm.message.domain.email.model.req.MailMessageSendReq;
import com.cqut.atao.farm.message.domain.email.model.res.MailSendMessageRes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SendMessageServiceImpl.java
 * @Description 消息发送编排
 * @createTime 2023年01月11日 17:02:00
 */
@Slf4j
@Service
@AllArgsConstructor
public class SendMessageServiceImpl implements SendMessageService {

    @Resource
    private MessageSendProduce messageSendProduce;

    @Override
    public MailSendMessageRes mailMessageSend(MailMessageSendReq req) {
        String messageSendId = IdUtil.getSnowflakeNextIdStr();
        MailMessageSendAggregates mailMessageSendAggregates = MailMessageSendAggregates.builder()
                .title(req.getTitle())
                .sender(req.getSender())
                .receiver(req.getReceiver())
                .cc(req.getCc())
                .paramList(req.getParamList())
                .messageSendId(messageSendId)
                .templateId(req.getTemplateId())
                .build();
        // MQ 异步发送邮件
        messageSendProduce.mailMessageSend(BeanUtil.toBean(mailMessageSendAggregates, MailMessageSendEvent.class));
        return new MailSendMessageRes(messageSendId);
    }
}

