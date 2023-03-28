package com.cqut.atao.farm.cart.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.cart.domain.mode.req.*;
import com.cqut.atao.farm.cart.domain.mode.res.CartItemRes;
import com.cqut.atao.farm.cart.domain.repository.CartItemRepository;
import com.cqut.atao.farm.cart.infrastructure.dao.CartItemDAO;
import com.cqut.atao.farm.cart.infrastructure.po.CartItem;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemRepositoryImpl.java
 * @Description 购物车仓储层
 * @createTime 2023年01月31日 21:48:00
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class CartItemRepositoryImpI implements CartItemRepository {

    @Resource
    private CartItemDAO cartItemDAO;

    @Override
    public Long queryCartItemNum(Long userId) {
        return cartItemDAO.selectCount(Wrappers.lambdaQuery(CartItem.class).eq(CartItem::getUserId,userId));
    }

    @Override
    public PageResponse<CartItemRes> pageQueryCartItem(String userId, PageRequest pageRequest) {
        LambdaQueryWrapper<CartItem> queryWrapper = Wrappers.lambdaQuery(CartItem.class)
                .eq(CartItem::getUserId, userId);
        Page<CartItem> selectPage = cartItemDAO.selectPage(new Page(pageRequest.getCurrent(), pageRequest.getSize()), queryWrapper);
        return PageUtil.convert(selectPage, CartItemRes.class);
    }

    @Override
    public List<CartItemRes> querySelectedCartItem(String userId) {
        LambdaQueryWrapper<CartItem> queryWrapper = Wrappers.lambdaQuery(CartItem.class)
                .eq(CartItem::getUserId,userId)
                .eq(CartItem::getSelectFlag,1);
        List<CartItem> cartItemPOS = cartItemDAO.selectList(queryWrapper);
        return BeanUtil.convert(cartItemPOS, CartItemRes.class);
    }

    @Override
    public void updateSelectedCartItem(CartItemSelectedReq req) {
        int res = cartItemDAO.updateCartItemSelected(req);
        Assert.isTrue(res > 0, () -> new ServiceException("修改购物车选中状态失败"));
    }

    @Override
    public void addCartItem(CartItemAddReq req) {
        CartItem cartItemPO = BeanUtil.convert(req, CartItem.class);
        int res = cartItemDAO.insert(cartItemPO);
        Assert.isTrue(res > 0, () -> new ServiceException("购物车新增商品失败"));
    }

    @Override
    public void updateCartItem(CartItemNumReq req) {
        int updateFlag = cartItemDAO.updateCartItemNum(req);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("修改购物车商品数量失败"));
    }

    @Override
    public void clearCartItem(CartItemClearReq cartItem) {
        LambdaUpdateWrapper<CartItem> updateWrapper = Wrappers.lambdaUpdate(CartItem.class)
                .eq(CartItem::getUserId, cartItem.getUserId());
        int updateFlag = cartItemDAO.delete(updateWrapper);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("清空购物车失败"));
    }

    @Override
    public void deleteCartItem(CartItemDeleteReq req) {
        for (Long skuid: req.getSkuIds()) {
             LambdaQueryWrapper<CartItem> wrapper = Wrappers.lambdaQuery(CartItem.class)
                    .eq(CartItem::getUserId, req.getUserId())
                    .eq(CartItem::getProductSkuId, skuid);
             int delete = cartItemDAO.delete(wrapper);
             Assert.isTrue(delete > 0 , () -> new ServiceException("删除购物车商品失败"));
        }
    }

    @Override
    public void selectedAllCartItem(Long userId) {
        List<CartItem> cartItems = cartItemDAO.selectList(Wrappers.lambdaQuery(CartItem.class).eq(CartItem::getUserId, userId));
        if (cartItems == null || cartItems.size() == 0) {
            return;
        }
        cartItems.forEach(e->{
             CartItemSelectedReq selectedReq = CartItemSelectedReq.builder()
                    .id(e.getId() + "")
                    .selectFlag(1)
                    .build();
            cartItemDAO.updateCartItemSelected(selectedReq);
        });
    }

    @Override
    public void cancelSelectedAllCartItem(Long userId) {
        List<CartItem> cartItems = cartItemDAO.selectList(Wrappers.lambdaQuery(CartItem.class).eq(CartItem::getUserId, userId));
        if (cartItems == null || cartItems.size() == 0) {
            return;
        }
        cartItems.forEach(e->{
            CartItemSelectedReq selectedReq = CartItemSelectedReq.builder()
                    .id(e.getId() + "")
                    .selectFlag(0)
                    .build();
            cartItemDAO.updateCartItemSelected(selectedReq);
        });
    }
}
