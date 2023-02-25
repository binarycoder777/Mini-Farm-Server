package com.cqut.atao.farm.pay.web;

import com.cqut.atao.farm.rocketmq.springboot.starter.message.MessageSink;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayApplication.java
 * @Description 支付服务启动类
 * @createTime 2023年02月21日 17:20:00
 */
@EnableDiscoveryClient
@EnableBinding({Source.class, MessageSink.class})
@EnableFeignClients("com.cqut.atao.farm.pay.domain.remote")
@SpringBootApplication(scanBasePackages = "com.cqut.atao.farm.pay")
@MapperScan("com.cqut.atao.farm.order.infrastructure.dao")
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class,args);
    }

}
