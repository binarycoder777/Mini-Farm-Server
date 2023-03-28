package com.cqut.atao.farm.cart.application.service;


import com.cqut.atao.farm.cart.domain.mode.req.*;
import com.cqut.atao.farm.cart.domain.mode.res.CartItemRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemService.java
 * @Description 购物车服务接口
 * @createTime 2023年01月31日 21:31:00
 */
public interface CartItemService {

    /**
     * 查询购物车商品数量
     *
     * @param userId
     * @return nums
     */
    Long queryCartItemNum(Long userId);


    /**
     * 分页查询购物车商品
     *
     * @param requestParam
     * @return
     */
    PageResponse<CartItemRes> pageQueryCartItem(CartItemPageQueryReq requestParam);


    /**
     * 查询选中商品的信息
     *
     * @param userId
     */
    List<CartItemRes> getSelectedCartItemInfo(String userId);

    /**
     * 修改购物车商品选中状态
     *
     * @param req {@link CartItemSelectedReq}
     */
    void updateSelectedCartItem(CartItemSelectedReq req);

    /**
     * 新增购物车商品
     *
     * @param req {@link CartItemAddReq}
     */
    void addCartItem(CartItemAddReq req);

    /**
     * 修改购物车商品数量
     *
     * @param req {@link CartItemNumReq}
     */
    void updateCartItemNum(CartItemNumReq req);

    /**
     * 清理购物车商品
     *
     * @param requestParam
     */
    void clearCartItem(CartItemClearReq requestParam);

    /**
     * 清理购物车商品
     *
     * @param requestParam
     */
    void deleteCartItem(CartItemDeleteReq requestParam);

    /**
     * 全选
     * @param userId
     */
    void selectedAllCartItem(Long userId);

    /**
     * 取消全选
     * @param userId
     */
    void cancelSelectedAllCartItem(Long userId);
}
