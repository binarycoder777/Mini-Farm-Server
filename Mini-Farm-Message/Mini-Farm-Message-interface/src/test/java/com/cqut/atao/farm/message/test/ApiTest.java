package com.cqut.atao.farm.message.test;

import cn.hutool.core.lang.UUID;
import com.cqut.atao.farm.message.application.service.SendMessageService;
import com.cqut.atao.farm.message.domain.email.model.aggregates.MailMessageSendAggregates;
import com.cqut.atao.farm.message.domain.email.model.req.MailMessageSendReq;
import com.cqut.atao.farm.message.domain.email.repository.MailMessageRepository;
import com.cqut.atao.farm.message.domain.email.repository.MailTemplateRepository;
import com.cqut.atao.farm.message.domain.email.service.MailMessageService;
import com.cqut.atao.farm.message.infrastructure.dao.MailTemplateDAO;
import com.cqut.atao.farm.message.web.MessageApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description api 测试类
 * @createTime 2023年01月15日 19:07:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessageApplication.class)
public class ApiTest {

    Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private MailTemplateDAO mailTemplateDAO;

    @Resource
    private MailMessageRepository mailMessageRepository;

    @Resource
    private MailMessageService mailMessageService;

    @Resource
    private SendMessageService sendMessageService;

    private MailMessageSendReq req;

    private MailMessageSendAggregates mailMessageSendAggregates;

    @Before
    public void before() {
        List<String> para = new ArrayList<String>();
        para.add("hello world!");
        req = MailMessageSendReq.builder()
                .title("邮件发送测试")
                .sender("1683823409@qq.com")
                .receiver("87337334@qq.com")
                .cc("")
                .paramList(para)
                .templateId("userRegisterVerification")
                .build();
        mailMessageSendAggregates = MailMessageSendAggregates.builder()
                .title(req.getTitle())
                .sender(req.getSender())
                .receiver(req.getReceiver())
                .cc(req.getCc())
                .paramList(req.getParamList())
                .messageSendId(UUID.randomUUID().toString())
                .templateId(req.getTemplateId())
                .build();
    }

    @Test
    public void testMailMessageRepository() {
        mailMessageRepository.saveMailMessage(mailMessageSendAggregates);
    }

    @Test
    public void testDao(){
        logger.info("测试数据库：{}",mailTemplateDAO.selectList(null));
    }

    @Test
    public void testMailMessageSend() {
        mailMessageService.send(mailMessageSendAggregates);
    }

    @Test
    public void testMQMailMessageSend() {
        sendMessageService.mailMessageSend(req);
    }

}
