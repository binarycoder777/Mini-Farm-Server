package com.cqut.atao.farm.message.application.service;

import com.cqut.atao.farm.message.domain.email.model.req.MailMessageSendReq;
import com.cqut.atao.farm.message.domain.email.model.res.MailSendMessageRes;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IMessageSendService.java
 * @Description 消息发送接口
 * @createTime 2023年01月11日 17:01:00
 */
public interface SendMessageService {

    /**
     * 邮箱消息发送
     *
     * @param mailMessageSendReq
     * @return MessageSendRes
     */
    MailSendMessageRes mailMessageSend(MailMessageSendReq mailMessageSendReq);


}
