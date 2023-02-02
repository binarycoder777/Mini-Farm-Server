package com.cqut.atao.farm.cart.test;

import com.cqut.atao.farm.cart.application.req.CartItemPageQueryReq;
import com.cqut.atao.farm.cart.application.service.CartItemService;
import com.cqut.atao.farm.cart.infrastructure.dao.CartItemDAO;
import com.cqut.atao.farm.cart.web.CartApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description api 测试
 * @createTime 2023年01月31日 22:03:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class)
public class ApiTest {

    @Resource
    private CartItemService cartItemService;

    @Resource
    private CartItemDAO cartItemDAO;

    private CartItemPageQueryReq pageQueryReq;

    @Before
    public void get() {
        pageQueryReq = CartItemPageQueryReq
                .builder()
                .customerUserId("1547742028312375296")
                .build();
        pageQueryReq.setCurrent(0l);
        pageQueryReq.setSize(10l);
    }

    @Test
    public void test0() {
        log.info("购物车列表-->{}",cartItemDAO.selectById(1572421595587436544l));
    }


    @Test
    public void test() {
        log.info("购物车列表-->{}",cartItemService.pageQueryCartItem(pageQueryReq));
    }

}
