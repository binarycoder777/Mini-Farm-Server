package com.cqut.atao.farm.order.domain.remote;

import com.cqut.atao.farm.order.domain.remote.model.req.DeleteCartItemReq;
import com.cqut.atao.farm.order.domain.remote.model.res.CartItemRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteCartService.java
 * @Description 远程购物车服务
 * @createTime 2023年02月18日 08:57:00
 */
@FeignClient("cart")
public interface RemoteCartService {


    /**
     * 获取购物车已选中商品
     */
    @GetMapping("/api/cart/product/selected/{userId}")
    Result<List<CartItemRes>> findSelectedCartProduct(@PathVariable("userId") Long userId);


    /**
     * 删除购物车商品
     */
    @DeleteMapping("/api/cart/product/delete")
    Result<Void> deleteCartProduct(@RequestBody DeleteCartItemReq req);

}
