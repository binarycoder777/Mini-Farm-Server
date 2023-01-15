package com.cqut.atao.farm.message.domain.email.model.aggregates;

import lombok.*;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageSendReq.java
 * @Description MailMessageSendReq
 * @createTime 2023年01月11日 19:12:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class MailMessageSendAggregates {

    /**
     * 标题
     */
    private String title;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    /**
     * 抄送
     */
    private String cc;

    /**
     * 消息参数
     */
    private List<String> paramList;

    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 消息发送ID
     */
    private String messageSendId;

    /**
     * 发送结果
     */
    private Boolean sendResult;

    public void setSendResult(boolean sendResult) {
        this.sendResult = sendResult;
    }
}
