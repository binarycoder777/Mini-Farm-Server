package com.cqut.atao.farm.pay.domain.remote;

import com.cqut.atao.farm.pay.domain.model.aggreate.Order;
import com.cqut.atao.farm.pay.domain.remote.model.res.OrderInfoRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteOrderService.java
 * @Description 远程订单服务
 * @createTime 2023年03月01日 20:48:00
 */
@FeignClient("order")
public interface RemoteOrderService {

    @GetMapping("/api/order/get/{orderSn}")
    public Result<OrderInfoRes> getOrderInfoByOrderSn(@PathVariable("orderSn") String orderSn);

    @GetMapping("/api/order/detail/{orderSn}")
    public Result<Order> orderDetail(@PathVariable("orderSn") String orderSn);

}
