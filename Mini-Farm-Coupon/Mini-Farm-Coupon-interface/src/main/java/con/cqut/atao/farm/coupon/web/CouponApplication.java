package con.cqut.atao.farm.coupon.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponApplication.java
 * @Description 服务启动类
 * @createTime 2023年03月12日 13:46:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.cqut.atao.farm.coupon.infrastructure.dao")
public class CouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class,args);
    }

}
