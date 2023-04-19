package com.cqut.atao.farm.coupon.domain.remote;

import com.cqut.atao.farm.coupon.domain.remote.model.req.PlaceOrderReq;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageRemoteService.java
 * @Description 远程订单服务
 * @createTime 2023年03月13日 21:29:00
 */
@FeignClient("order")
public interface RemoteOrderService {

    @PostMapping("/api/order/kill/create")
    @ApiOperation("秒杀商品下单")
    Result<String> createKillOrder(@RequestBody PlaceOrderReq req);

}
