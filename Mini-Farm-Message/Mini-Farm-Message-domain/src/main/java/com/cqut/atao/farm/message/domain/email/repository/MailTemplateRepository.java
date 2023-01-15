package com.cqut.atao.farm.message.domain.email.repository;

import com.cqut.atao.farm.message.domain.email.model.aggregates.MailMessageSendAggregates;
import com.cqut.atao.farm.message.domain.email.model.vo.MailTemplateVO;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailTemplatRepository.java
 * @Description 邮件模版仓储接口
 * @createTime 2023年01月11日 19:44:00
 */
public interface MailTemplateRepository {


    List<MailTemplateVO> selectList(MailMessageSendAggregates req);

    void saveMailMessage(MailMessageSendAggregates messageSend);
}
