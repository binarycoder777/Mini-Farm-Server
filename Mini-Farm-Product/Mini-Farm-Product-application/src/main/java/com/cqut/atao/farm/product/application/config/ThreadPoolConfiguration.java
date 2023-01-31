package com.cqut.atao.farm.product.application.config;

import cn.hippo4j.core.executor.DynamicThreadPool;
import cn.hippo4j.core.executor.support.ThreadPoolBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ThreadPoolConfiguration.java
 * @Description 线程池配置类
 * @createTime 2023年01月31日 19:11:00
 */
@Configuration
public class ThreadPoolConfiguration {

    @Bean
    @DynamicThreadPool
    public ThreadPoolExecutor productThreadPoolExecutor() {
        String productThreadPoolId = "product-executor";
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolBuilder.builder()
                .threadPoolId(productThreadPoolId)
                .threadFactory(productThreadPoolId)
                .dynamicPool()
                .build();
        return threadPoolExecutor;
    }

}
