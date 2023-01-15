package com.cqut.atao.farm.message.web.controller;


import com.cqut.atao.farm.message.application.service.SendMessageService;
import com.cqut.atao.farm.message.domain.email.model.req.MailMessageSendReq;
import com.cqut.atao.farm.message.domain.email.model.res.MailSendMessageRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageSendController.java
 * @Description 消息发送控制器
 * @createTime 2023年01月11日 17:14:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "消息发送")
@RequestMapping("/api/message")
public class MessageSendController {

    private final SendMessageService messageSendService;

    @PostMapping("/send/mail")
    @ApiOperation("发送邮箱消息")
    public Result<MailSendMessageRes> sendMailMessage(@RequestBody @Valid MailMessageSendReq req) {
        MailSendMessageRes result = messageSendService.mailMessageSend(req);
        return Results.success(result);
    }

}
