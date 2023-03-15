package com.cqut.atao.farm.coupon.domain.remote;

import com.cqut.atao.farm.coupon.domain.remote.model.req.MailMessageSendReq;
import com.cqut.atao.farm.coupon.domain.remote.model.res.MailSendMessageRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageRemoteService.java
 * @Description 消息远程服务
 * @createTime 2023年03月13日 21:29:00
 */
@FeignClient
public interface RemoteMessageService {

    @PostMapping("/api/message/send/mail")
    Result<MailSendMessageRes> sendMailMessage(@RequestBody @Valid MailMessageSendReq req);

}
