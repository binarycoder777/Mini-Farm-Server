package com.cqut.atao.farm.product.web;

import com.cqut.atao.farm.product.domain.mq.messaging.MessageSink;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductApplication.java
 * @Description 商品服务启动类
 * @createTime 2023年01月30日 15:46:00
 */
@EnableDiscoveryClient
@EnableBinding({Source.class, MessageSink.class})
@EnableFeignClients("com.cqut.atao.farm.product.domain.remote")
@EnableElasticsearchRepositories(basePackages = "com.cqut.atao.farm.product.infrastructure.es")
@SpringBootApplication(scanBasePackages = "com.cqut.atao.farm.product")
@MapperScan("com.cqut.atao.farm.product.infrastructure.dao")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
