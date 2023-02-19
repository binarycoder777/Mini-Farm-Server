package com.cqut.atao.farm.cart.domain.repository;


import com.cqut.atao.farm.cart.domain.mode.req.*;
import com.cqut.atao.farm.cart.domain.mode.res.CartItemRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemRepository.java
 * @Description 购物车仓储层接口
 * @createTime 2023年01月31日 21:47:00
 */
public interface CartItemRepository {

    /**
     * 分页查询购物车商品
     *
     * @param userId      用户id
     * @param pageRequest 分页请求
     * @return {@link PageResponse< CartItemRes >}
     */
    PageResponse<CartItemRes> pageQueryCartItem(String userId, PageRequest pageRequest);

    /**
     * 查询购物车已选中商品
     *
     * @param userId 用户id
     * @return {@link List< CartItemRes >}
     */
    List<CartItemRes> querySelectedCartItem(String userId);

    /**
     * 更新购物车商品选中状态
     *
     * @param req
     */
    void updateSelectedCartItem(CartItemSelectedReq req);

    /**
     * 新增购物车商品
     *
     * @param req
     */
    void addCartItem(CartItemAddReq req);

    /**
     * 修改购物车商品
     *
     * @param req
     */
    void updateCartItem(CartItemNumReq req);

    /**
     * 删除购物车商品
     *
     * @param req
     */
    void clearCartItem(CartItemClearReq req);

    /**
     * 删除购物车商品
     *
     * @param req
     */
    void deleteCartItem(CartItemDeleteReq req);
}
