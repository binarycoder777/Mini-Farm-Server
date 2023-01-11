package com.cqut.atao.farm.springboot.starter.web.config;

import com.cqut.atao.farm.springboot.starter.web.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WebAutoConfiguration.java
 * @Description Web 组件自动装配
 * @createTime 2023年01月11日 14:41:00
 */
@Configuration
public class WebAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler congoMallGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
