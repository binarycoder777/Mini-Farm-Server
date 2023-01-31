package com.cqut.atao.farm.cart.domain.repository;

import com.cqut.atao.farm.cart.domain.mode.aggregate.CartItem;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

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
     * @param userId
     * @param pageRequest
     * @return
     */
    PageResponse<CartItem> pageQueryCartItem(String userId, PageRequest pageRequest);


}
