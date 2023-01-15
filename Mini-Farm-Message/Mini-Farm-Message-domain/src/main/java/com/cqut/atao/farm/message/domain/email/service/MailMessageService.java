package com.cqut.atao.farm.message.domain.email.service;

import com.cqut.atao.farm.message.domain.email.model.aggregates.MailMessageSendAggregates;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IMailMessageService.java
 * @Description 邮箱消息服务接口
 * @createTime 2023年01月11日 17:46:00
 */
public interface MailMessageService {

    /**
     * 发送邮件
     *
     * @param req
     * @return
     */
    boolean send(MailMessageSendAggregates req);

    /**
     * 保存邮件发送记录
     *
     * @param messageSend
     */
    void saveMailMessage(MailMessageSendAggregates messageSend);
}
