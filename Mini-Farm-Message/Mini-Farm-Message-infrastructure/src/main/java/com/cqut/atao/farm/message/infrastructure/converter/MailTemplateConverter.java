package com.cqut.atao.farm.message.infrastructure.converter;

import com.cqut.atao.farm.message.domain.email.model.vo.MailTemplateVO;
import com.cqut.atao.farm.message.infrastructure.po.MailTemplatePO;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailTemplateConverter.java
 * @Description 邮件模版对象转换器
 * @createTime 2023年01月11日 22:21:00
 */
public interface MailTemplateConverter {

    // todo 待定
    MailTemplateVO mailPOToVO(MailTemplatePO mailTemplatePO);

}
