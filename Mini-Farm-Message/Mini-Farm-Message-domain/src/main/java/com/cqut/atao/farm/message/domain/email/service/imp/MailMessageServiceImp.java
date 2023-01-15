package com.cqut.atao.farm.message.domain.email.service.imp;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.cqut.atao.farm.message.domain.email.model.aggregates.MailMessageSendAggregates;
import com.cqut.atao.farm.message.domain.email.model.vo.MailTemplateVO;
import com.cqut.atao.farm.message.domain.email.repository.MailMessageRepository;
import com.cqut.atao.farm.message.domain.email.repository.MailTemplateRepository;
import com.cqut.atao.farm.message.domain.email.service.MailMessageService;
import com.cqut.atao.farm.springboot.starter.base.init.ApplicationInitializingEvent;
import com.google.common.collect.Maps;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailMessageServiceImp.java
 * @Description 邮件信息服务
 * @createTime 2023年01月11日 17:50:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class MailMessageServiceImp implements ApplicationListener<ApplicationInitializingEvent>, MailMessageService {

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private MailTemplateRepository mailTemplateRepository;

    private final Configuration configuration;

    private final JavaMailSender javaMailSender;

    @SneakyThrows
    @Override
    public boolean send(MailMessageSendAggregates messageSend) {
        try {
            // 1.查询邮件模版列表
            List<MailTemplateVO> mailTemplateDOS = mailTemplateRepository.selectList(messageSend);
            // 2.创建邮件信息
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(messageSend.getSender());
            helper.setSubject(messageSend.getTitle());
            if (StrUtil.isNotBlank(messageSend.getCc())) {
                helper.setCc(messageSend.getCc().split(","));
            }
            if (StrUtil.isNotBlank(messageSend.getReceiver())) {
                helper.setTo(messageSend.getReceiver().split(","));
            }
            Map<String, Object> model = Maps.newHashMap();
            if (CollUtil.isNotEmpty(messageSend.getParamList())) {
                for (int i = 0; i < mailTemplateDOS.size(); i++) {
                    model.put(mailTemplateDOS.get(i).getTemplateParam(), messageSend.getParamList().get(i));
                }
            }
            String templateKey = messageSend.getTemplateId() + ".ftl";
            Template template = Singleton.get(templateKey, () -> {
                try {
                    return configuration.getTemplate(templateKey);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            // 3.构建邮件模版
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html, true);
            // 4.发送邮件
            javaMailSender.send(mimeMessage);
        } catch (Throwable ex) {
            log.error("邮件发送失败，Request: {}", JSONUtil.toJsonStr(messageSend), ex);
            return false;
        }
        return true;
    }

    /**
     * 初始化邮箱模板
     */
    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationInitializingEvent event) {
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(ResourceUtils.CLASSPATH_URL_PREFIX + "templates/*.ftl");
        for (Resource resource : resources) {
            String templateName = resource.getFilename();
            Singleton.put(templateName, configuration.getTemplate(templateName));
        }
    }

    @Override
    public void saveMailMessage(MailMessageSendAggregates messageSend) {
        mailMessageRepository.saveMailMessage(messageSend);
    }
}
