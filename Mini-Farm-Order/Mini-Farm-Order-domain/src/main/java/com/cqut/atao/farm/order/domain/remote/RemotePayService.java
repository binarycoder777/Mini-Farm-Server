package com.cqut.atao.farm.order.domain.remote;

import com.cqut.atao.farm.order.domain.remote.model.req.DeleteCartItemReq;
import com.cqut.atao.farm.order.domain.remote.model.res.CartItemRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteCartService.java
 * @Description 远程支付服务
 * @createTime 2023年02月18日 08:57:00
 */
@FeignClient("pay")
public interface RemotePayService {

    @PostMapping("/refund/notify")
    Result<Void> notifyRefundMoney(@RequestBody Object o);

}
