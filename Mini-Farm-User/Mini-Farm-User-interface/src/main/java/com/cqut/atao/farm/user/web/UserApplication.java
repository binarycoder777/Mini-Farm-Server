package com.cqut.atao.farm.user.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserApplication.java
 * @Description 用户服务启动类
 * @createTime 2023年01月12日 19:30:00
 */
@EnableDiscoveryClient
@MapperScan("com.cqut.atao.farm.user.infrastructure.dao")
@SpringBootApplication(scanBasePackages = "com.cqut.atao.farm.user")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }

}
