package com.cqut.atao.farm.cart.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.cart.domain.mode.aggregate.CartItem;
import com.cqut.atao.farm.cart.domain.repository.CartItemRepository;
import com.cqut.atao.farm.cart.infrastructure.dao.CartItemDAO;
import com.cqut.atao.farm.cart.infrastructure.po.CartItemPO;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
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

    @Override
    public List<CartItem> querySelectedCartItem(String userId) {
        LambdaQueryWrapper<CartItemPO> queryWrapper = Wrappers.lambdaQuery(CartItemPO.class)
                .eq(CartItemPO::getCustomerUserId,userId)
                .eq(CartItemPO::getSelectFlag,1);
        List<CartItemPO> cartItemPOS = cartItemDAO.selectList(queryWrapper);
        return BeanUtil.convert(cartItemPOS,CartItem.class);
    }

    @Override
    public void updateSelectedCartItem(CartItem req) {
        CartItemPO cartItemPO = BeanUtil.convert(req, CartItemPO.class);
        int res = cartItemDAO.updateById(cartItemPO);
        Assert.isTrue(res > 0, () -> new ServiceException("修改购物车选中状态失败"));
    }

    @Override
    public void addCartItem(CartItem req) {
        CartItemPO cartItemPO = BeanUtil.convert(req, CartItemPO.class);
        int res = cartItemDAO.insert(cartItemPO);
        Assert.isTrue(res > 0, () -> new ServiceException("购物车新增商品失败"));
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        CartItemPO cartItemPO = BeanUtil.convert(cartItem, CartItemPO.class);
        int updateFlag = cartItemDAO.updateById(cartItemPO);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("修改购物车失败"));
    }

    @Override
    public void clearCartItem(CartItem cartItem) {
        LambdaUpdateWrapper<CartItemPO> updateWrapper = Wrappers.lambdaUpdate(CartItemPO.class)
                .eq(CartItemPO::getCustomerUserId, cartItem.getCustomerUserId())
                .in(CartItemPO::getProductSkuId, cartItem.getSkuIds());
        int updateFlag = cartItemDAO.delete(updateWrapper);
        Assert.isTrue(updateFlag > 0, () -> new ServiceException("删除购物车失败"));
    }
}
