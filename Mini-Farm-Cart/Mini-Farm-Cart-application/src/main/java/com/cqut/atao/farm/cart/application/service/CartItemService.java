package com.cqut.atao.farm.cart.application.service;

import com.cqut.atao.farm.cart.application.req.CartItemPageQueryReq;
import com.cqut.atao.farm.cart.application.res.CartItemRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemService.java
 * @Description 购物车服务接口
 * @createTime 2023年01月31日 21:31:00
 */
public interface CartItemService {

    /**
     * 分页查询购物车商品
     *
     * @param requestParam
     * @return
     */
    PageResponse<CartItemRes> pageQueryCartItem(CartItemPageQueryReq requestParam);

}
