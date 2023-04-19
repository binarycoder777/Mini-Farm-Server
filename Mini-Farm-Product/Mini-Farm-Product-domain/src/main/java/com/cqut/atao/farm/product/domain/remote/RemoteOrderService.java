package com.cqut.atao.farm.product.domain.remote;

import com.cqut.atao.farm.product.domain.remote.model.req.PlaceOrderReq;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteOrderService.java
 * @Description 订单远程服务
 * @createTime 2023年04月09日 19:42:00
 */
@FeignClient("order")
public interface RemoteOrderService {

    @GetMapping("/api/order/comment/status/{orderSn}")
    public Result<Void> alterOrderStatusToComment(@PathVariable("orderSn") String orderSn);

    @PostMapping("/kill/create")
    Result<String> createKillOrder(@RequestBody PlaceOrderReq req);


    @PostMapping("/kill/cancel/{orderSn}")
    Result<Void> cancelKillOrder(@PathVariable("orderSn") String orderNo);

}
