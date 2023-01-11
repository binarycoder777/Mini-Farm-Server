package com.cqut.atao.farm.message.application.service.impI;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.cqut.atao.farm.message.application.mq.event.MailMessageSendEvent;
import com.cqut.atao.farm.message.application.mq.produce.MessageSendProduce;
import com.cqut.atao.farm.message.application.req.MailSendReq;
import com.cqut.atao.farm.message.application.res.MailSendRes;
import com.cqut.atao.farm.message.application.service.SendMessageService;
import com.cqut.atao.farm.message.domain.email.model.req.MailMessageSendReq;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SendMessageServiceImpl.java
 * @Description 消息发送
 * @createTime 2023年01月11日 17:02:00
 */
@Slf4j
@Service
@AllArgsConstructor
public class SendMessageServiceImpl implements SendMessageService {

    private final MessageSendProduce messageSendProduce;

    @Override
    public MailSendRes mailMessageSend(MailSendReq req) {
        String messageSendId = IdUtil.getSnowflakeNextIdStr();
        MailMessageSendReq messageSend = MailMessageSendReq.builder()
                .title(req.getTitle())
                .sender(req.getSender())
                .receiver(req.getReceiver())
                .cc(req.getCc())
                .paramList(req.getParamList())
                .messageSendId(messageSendId)
                .templateId(req.getTemplateId())
                .build();
        messageSendProduce.mailMessageSend(BeanUtil.toBean(messageSend, MailMessageSendEvent.class));
        return new MailSendRes(messageSendId);
    }
}

