package com.cqut.atao.farm.message.infrastructure.respository;

import com.cqut.atao.farm.message.domain.email.model.aggregates.MailMessageSendAggregates;
import com.cqut.atao.farm.message.domain.email.repository.MailMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailMessageRepositoryImp.java
 * @Description 邮件信息仓储
 * @createTime 2023年01月15日 22:44:00
 */
@Repository
@AllArgsConstructor
public class MailMessageRepositoryImp implements MailMessageRepository {


    @Override
    public void mailMessageSave(MailMessageSendAggregates req) {

    }

    @Override
    public void saveMailMessage(MailMessageSendAggregates req) {

    }
}
