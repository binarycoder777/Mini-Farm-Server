package com.cqut.atao.farm.rocketmq.springboot.starter.config;

import com.cqut.atao.farm.rocketmq.springboot.starter.aspect.StreamListenerLogPrintAspect;
import org.springframework.context.annotation.Bean;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RocketMQAutoConfiguration.java
 * @Description RocketMQ 自动装配
 * @createTime 2023年01月16日 10:40:00
 */
public final class RocketMQAutoConfiguration {

    @Bean
    public StreamListenerLogPrintAspect streamListenerLogPrintAspect() {
        return new StreamListenerLogPrintAspect();
    }
}
