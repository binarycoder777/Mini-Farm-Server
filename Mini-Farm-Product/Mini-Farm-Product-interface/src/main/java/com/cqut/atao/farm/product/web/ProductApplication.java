package com.cqut.atao.farm.product.web;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductApplication.java
 * @Description 商品服务启动类
 * @createTime 2023年01月30日 15:46:00
 */
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
