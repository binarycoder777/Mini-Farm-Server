package com.cqut.atao.farm.message.infrastructure.respository;

import cn.hutool.core.bean.BeanUtil;
import com.cqut.atao.farm.message.domain.email.model.aggregates.MailMessageSendAggregates;
import com.cqut.atao.farm.message.domain.email.repository.MailMessageRepository;
import com.cqut.atao.farm.message.infrastructure.dao.MailSendRecordDAO;
import com.cqut.atao.farm.message.infrastructure.po.MailSendRecordPO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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

    @Resource
    private MailSendRecordDAO mailSendRecordDAO;

    @Override
    public void saveMailMessage(MailMessageSendAggregates req) {
        mailSendRecordDAO.insert(BeanUtil.copyProperties(req, MailSendRecordPO.class));
    }
}
