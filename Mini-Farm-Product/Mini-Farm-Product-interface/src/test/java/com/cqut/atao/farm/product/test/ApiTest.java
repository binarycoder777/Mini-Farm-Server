package com.cqut.atao.farm.product.test;

import com.cqut.atao.farm.product.application.service.ProductService;
import com.cqut.atao.farm.product.web.ProductApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description API 测试
 * @createTime 2023年01月30日 20:08:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
public class ApiTest {

    @Resource
    private ProductService productService;

    @Test
    public void get() {
        Long spuId = 122l;
        log.info("根据spuId查找商品",productService.getProductBySpuId(spuId));
    }

}
