package com.cqut.atao.farm.springboot.starter.distributedid.config;

import com.cqut.atao.farm.springboot.starter.base.ApplicationContextHolder;
import com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake.choose.LocalRedisWorkIdChoose;
import com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake.choose.RandomWorkIdChoose;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DistributedIdAutoConfiguration.java
 * @Description 分布式 ID 自动装配
 * @createTime 2023年01月10日 20:37:00
 */
@Import(ApplicationContextHolder.class)
public class DistributedIdAutoConfiguration {

    @Bean
    @ConditionalOnProperty("spring.redis.host")
    public LocalRedisWorkIdChoose redisWorkIdChoose() {
        return new LocalRedisWorkIdChoose();
    }

    @Bean
    @ConditionalOnMissingBean(LocalRedisWorkIdChoose.class)
    public RandomWorkIdChoose randomWorkIdChoose() {
        return new RandomWorkIdChoose();
    }
}
