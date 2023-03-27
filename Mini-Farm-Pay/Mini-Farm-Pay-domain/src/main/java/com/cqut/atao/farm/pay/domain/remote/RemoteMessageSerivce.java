package com.cqut.atao.farm.pay.domain.remote;

import com.cqut.atao.farm.pay.domain.remote.model.req.MailMessageSendReq;
import com.cqut.atao.farm.pay.domain.remote.model.res.MailSendMessageRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteMessageSerivce.java
 * @Description 远程消息服务
 * @createTime 2023年02月23日 15:37:00
 */
@FeignClient
public interface RemoteMessageSerivce {

    @PostMapping("/api/message/send/mail")
    Result<MailSendMessageRes> sendMailMessage(@RequestBody @Valid MailMessageSendReq req);

}
