package com.cqut.atao.user.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserApplication.java
 * @Description 用户服务启动类
 * @createTime 2023年01月12日 19:30:00
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.cqut.atao.farm.user.domain")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class,args);
    }

}
