package com.cqut.atao.farm.cart.domain.repository;

import com.cqut.atao.farm.cart.domain.mode.aggregate.CartItem;
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
     * @return {@link PageResponse<CartItem>}
     */
    PageResponse<CartItem> pageQueryCartItem(String userId, PageRequest pageRequest);

    /**
     * 查询购物车已选中商品
     *
     * @param userId 用户id
     * @return {@link List<CartItem>}
     */
    List<CartItem> querySelectedCartItem(String userId);

    /**
     * 更新购物车商品选中状态
     *
     * @param req
     */
    void updateSelectedCartItem(CartItem req);

    /**
     * 新增购物车商品
     *
     * @param req
     */
    void addCartItem(CartItem req);

    /**
     * 修改购物车商品
     *
     * @param cartItem
     */
    void updateCartItem(CartItem cartItem);

    /**
     * 删除购物车商品
     *
     * @param cartItem
     */
    void clearCartItem(CartItem cartItem);
}
