package com.cqut.atao.farm.springboot.starter.log.config;

import com.cqut.atao.farm.springboot.starter.log.aspect.MiniLogPrintAspect;
import org.springframework.context.annotation.Bean;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
/**
 * @author atao
 * @version 1.0.0
 * @ClassName LogAutoConfiguration.java
 * @Description 日志自动装配
 * @createTime 2023年01月10日 17:18:00
 */
public class LogAutoConfiguration {
    /**
     * {@link MiniLog} 日志打印 AOP 切面
     */
    @Bean
    public MiniLogPrintAspect mLogPrintAspect() {
        return new MiniLogPrintAspect();
    }
}
