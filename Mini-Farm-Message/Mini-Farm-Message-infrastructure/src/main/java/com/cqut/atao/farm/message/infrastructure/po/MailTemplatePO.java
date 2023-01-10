package com.cqut.atao.farm.message.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailTemplatePO.java
 * @Description 邮件模板实体类
 * @createTime 2023年01月10日 16:14:00
 */
@Data
@TableName("mail_template")
public class MailTemplatePO {

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
