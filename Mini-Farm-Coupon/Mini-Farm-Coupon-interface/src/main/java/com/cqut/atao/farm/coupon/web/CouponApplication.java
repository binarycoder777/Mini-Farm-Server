package com.cqut.atao.farm.coupon.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponApplication.java
 * @Description 服务启动类
 * @createTime 2023年03月12日 13:46:00
 */
@EnableDiscoveryClient
@MapperScan("com.cqut.atao.farm.coupon.infrastructure.dao")
@EnableFeignClients("com.cqut.atao.farm.coupon.domain.remote")
@SpringBootApplication(scanBasePackages = "com.cqut.atao.farm.coupon")
public class CouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class,args);
    }

}
