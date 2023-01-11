package com.cqut.atao.farm.message.domain.email.model.vo;

import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailTemplateRes.java
 * @Description 邮件模版结果
 * @createTime 2023年01月11日 21:51:00
 */
@Data
public class MailTemplateVO {

    /**
     * ID
     */
    private Long id;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 模板参数
     */
    private String templateParam;

}
