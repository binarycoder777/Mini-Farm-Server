package com.cqut.atao.farm.order.domain.remote;

import com.cqut.atao.farm.order.domain.remote.model.req.CheckAmountReq;
import com.cqut.atao.farm.order.domain.remote.model.req.DeleteCartItemReq;
import com.cqut.atao.farm.order.domain.remote.model.req.LockProductStockReq;
import com.cqut.atao.farm.order.domain.remote.model.res.CheckAmountRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteProductService.java
 * @Description 远程商品服务
 * @createTime 2023年02月18日 10:34:00
 */
@FeignClient("product-service")
public interface RemoteProductService {

    /**
     * 核验购物车商品金额
     */
    @GetMapping("/api/check/amount")
    Result<CheckAmountRes> checkCartProductAmount(@RequestBody CheckAmountReq req);

    /**
     * 核验购物车商品金额
     */
    @PutMapping("/api/lock/stock")
    Result<Void> lockProductStock(@RequestBody LockProductStockReq req);


}
