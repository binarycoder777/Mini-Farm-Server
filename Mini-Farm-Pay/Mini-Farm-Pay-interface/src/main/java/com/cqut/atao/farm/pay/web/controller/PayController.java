package com.cqut.atao.farm.pay.web.controller;

import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayController.java
 * @Description 支付控制器
 * @createTime 2023年02月22日 09:30:00
 */
@Api
@MiniLog
@RestController
@RequestMapping("/api/pay")
public class PayController {


    @PostMapping("/pay")
    public Result<Void> payMoney(){
        return null;
    }

    @PostMapping("/refund")
    public Result<Void> refundMoney(){
        return null;
    }

    @PostMapping("/remit")
    public Result<Void> remitMoney(){
        return null;
    }

}
