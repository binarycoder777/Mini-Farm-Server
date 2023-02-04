package com.cqut.atao.farm.order.web.controller;

import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderController.java
 * @Description 订单控制类
 * @createTime 2023年02月04日 15:21:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "商品订单")
@RequestMapping("/api/order")
public class OrderController {



}
