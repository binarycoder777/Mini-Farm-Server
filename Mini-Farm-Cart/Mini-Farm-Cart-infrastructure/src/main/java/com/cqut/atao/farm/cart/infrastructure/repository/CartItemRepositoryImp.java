package com.cqut.atao.farm.cart.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.cart.domain.mode.aggregate.CartItem;
import com.cqut.atao.farm.cart.domain.repository.CartItemRepository;
import com.cqut.atao.farm.cart.infrastructure.dao.CartItemDAO;
import com.cqut.atao.farm.cart.infrastructure.po.CartItemPO;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemRepositoryImpl.java
 * @Description 购物车仓储层
 * @createTime 2023年01月31日 21:48:00
 */
@Slf4j
@Repository
public class CartItemRepositoryImp implements CartItemRepository {

    @Resource
    private CartItemDAO cartItemDAO;

    @Override
    public PageResponse<CartItem> pageQueryCartItem(String userId, PageRequest pageRequest) {
        LambdaQueryWrapper<CartItemPO> queryWrapper = Wrappers.lambdaQuery(CartItemPO.class)
                .eq(CartItemPO::getCustomerUserId, userId);
        Page<CartItemPO> selectPage = cartItemDAO.selectPage(new Page(pageRequest.getCurrent(), pageRequest.getSize()), queryWrapper);
        return PageUtil.convert(selectPage, CartItem.class);
    }

}
