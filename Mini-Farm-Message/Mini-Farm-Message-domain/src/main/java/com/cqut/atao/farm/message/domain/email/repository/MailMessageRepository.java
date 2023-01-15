package com.cqut.atao.farm.message.domain.email.repository;

import com.cqut.atao.farm.message.domain.email.model.aggregates.MailMessageSendAggregates;
import com.cqut.atao.farm.message.domain.email.model.req.MailMessageSendReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageSendRepository.java
 * @Description 消息发送仓储层
 * @createTime 2023年01月11日 19:21:00
 */
public interface MailMessageRepository {

    /**
     * 邮箱消息发送
     *
     * @param req MailMessageSendReq
     */
    void mailMessageSave(MailMessageSendAggregates req);

    /**
     * 保存邮件信息记录
     *
     * @param req MailMessageSendReq
     */
    void saveMailMessage(MailMessageSendAggregates req);

}
