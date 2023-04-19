package com.cqut.atao.farm.coupon.application.worker;


import com.cqut.atao.farm.coupon.domain.activity.kill.model.res.KillNoticeRecord;
import com.cqut.atao.farm.coupon.domain.activity.repository.KillRepository;
import com.cqut.atao.farm.coupon.domain.remote.RemoteMessageService;
import com.cqut.atao.farm.coupon.domain.remote.RemoteUserSerivce;
import com.cqut.atao.farm.coupon.domain.remote.model.req.MailMessageSendReq;
import com.cqut.atao.farm.coupon.domain.remote.model.res.UserInfoRes;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName LotteryXxlJob.java
 * @Description 抽奖业务，任务配置
 * @createTime 2022年06月12日 16:54:00
 */
@Slf4j
@Component
public class CouponXxlJob {

    @Resource
    private KillRepository killRepository;

    @Resource
    private RemoteMessageService remoteMessageService;

    @Resource
    private RemoteUserSerivce remoteUserSerivce;

    /**
     * 提醒秒杀抢购
     *
     * @throws Exception
     */
    @XxlJob("noticeBuyKillProductHandler")
    public void lotteryActivityStateJobHandler() throws Exception {
        List<KillNoticeRecord> records = killRepository.queryNotice();
        for (int i = 0; i < records.size(); ++i) {
            // 满足10分钟内,发起提醒
            if ((records.get(i).getKillTime().getTime() - System.currentTimeMillis() < 1000 * 60 * 10)) {
                UserInfoRes userInfoRes = remoteUserSerivce.getUserInfoByUserId(records.get(i).getUserId()).getData();
                List<String> para = new ArrayList<String>();
                MailMessageSendReq req = MailMessageSendReq.builder()
                        .title("秒杀商品提醒")
                        .sender("1683823409@qq.com")
                        .receiver(userInfoRes.getMail())
                        .cc("")
                        .paramList(para)
                        .templateId("userRegisterVerification")
                        .build();
                remoteMessageService.sendMailMessage(req);
            }
        }
    }

}

