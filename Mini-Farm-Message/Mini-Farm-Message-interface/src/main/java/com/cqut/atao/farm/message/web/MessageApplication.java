package com.cqut.atao.farm.message.web;

import com.cqut.atao.farm.message.application.mq.messaging.MessageSink;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageApplication.java
 * @Description 消息服务启动类
 * @createTime 2023年01月11日 17:12:00
 */
@EnableDiscoveryClient
@EnableBinding({Source.class, MessageSink.class})
@MapperScan("com.cqut.atao.farm.message.infrastructure.dao")
@SpringBootApplication(scanBasePackages = "com.cqut.atao.farm.message")
public class MessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }
}
