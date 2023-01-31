package com.cqut.atao.farm.cart.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartApplication.java
 * @Description 购物车服务启动类
 * @createTime 2023年01月31日 21:23:00
 */
@EnableDiscoveryClient
@MapperScan("com.cqut.atao.farm.cart.infrastructure.dao")
@SpringBootApplication(scanBasePackages = "com.cqut.atao.farm.cart")
public class CartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
}
