package com.cqut.atao.farm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName GatewayApplication.java
 * @Description 网关服务
 * @createTime 2023年04月20日 14:28:00
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
