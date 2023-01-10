package com.cqut.atao.farm.message.infrastructure.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailSendRecordPO.java
 * @Description 邮件消息发送类
 * @createTime 2023年01月10日 16:15:00
 */
@Data
@TableName("mail_send_record")
public class MailSendRecordPO {


    /**
     * id
     */
    private Long id;

    /**
     * 消息发送id
     */
    private String messageSendId;

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    /**
     * 抄送者
     */
    private String cc;

    /**
     * 文本参数
     */
    private String paramList;

    /**
     * 状态 0：失败 1：成功
     */
    private Integer status;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 删除标志
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;

}
