package com.cqut.atao.farm.pay.domain.thirdpayment.strategy;

import com.cqut.atao.farm.pay.domain.model.aggreate.Order;
import com.cqut.atao.farm.pay.domain.remote.RemoteMessageSerivce;
import com.cqut.atao.farm.pay.domain.remote.RemoteUserSerivce;
import com.cqut.atao.farm.pay.domain.remote.model.req.MailMessageSendReq;
import com.cqut.atao.farm.pay.domain.remote.model.res.UserInfoRes;
import com.cqut.atao.farm.pay.domain.thirdpayment.ThirdPay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName VxPayStrategy.java
 * @Description 微信小程序中进行微信支付策略
 * @createTime 2023年02月23日 15:14:00
 */
@Component
@Slf4j
public class VxPayStrategy implements ThirdPay {

    @Resource
    private RemoteUserSerivce remoteUserSerivce;

    @Resource
    private RemoteMessageSerivce remoteMessageSerivce;


    @Override
    public Object generatePaySign(Order order) {
        log.info("生成微信支付签名");
        return "success";
    }

    @Override
    public void notifyPayResult(Order orderInfo) {
//        UserInfoRes userInfo = remoteUserSerivce.getUserInfoByUserId(orderInfo.getUserId()).getData();
        List<String> para = new ArrayList<String>();
        para.add("支付成功!");
        MailMessageSendReq req = MailMessageSendReq.builder()
                .title("邮件发送测试")
                .sender("1683823409@qq.com")
                .receiver("87337334@qq.com")
                .cc("")
                .paramList(para)
                .templateId("userRegisterVerification")
                .build();
        remoteMessageSerivce.sendMailMessage(req);
    }

    @Override
    public Object refundMoneyReq(Object o) {
        log.info("发起微信支付退款");
        return "success";
    }

    @Override
    public void notifyRefundResult(Order orderInfo) {
        UserInfoRes userInfo = remoteUserSerivce.getUserInfoByUserId(orderInfo.getUserId()).getData();
        List<String> para = new ArrayList<String>();
        para.add("退款成功!");
        MailMessageSendReq req = MailMessageSendReq.builder()
                .title("邮件发送测试")
                .sender("1683823409@qq.com")
                .receiver(userInfo.getMail())
                .cc("")
                .paramList(para)
                .templateId("userRegisterVerification")
                .build();
        remoteMessageSerivce.sendMailMessage(req);
    }


}
