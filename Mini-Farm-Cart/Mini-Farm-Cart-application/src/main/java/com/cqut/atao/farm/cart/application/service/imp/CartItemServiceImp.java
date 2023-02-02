package com.cqut.atao.farm.cart.application.service.imp;

import com.cqut.atao.farm.cart.application.req.*;
import com.cqut.atao.farm.cart.application.res.CartItemRes;
import com.cqut.atao.farm.cart.application.service.CartItemService;
import com.cqut.atao.farm.cart.domain.mode.aggregate.CartItem;
import com.cqut.atao.farm.cart.domain.repository.CartItemRepository;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemServiceImp.java
 * @Description 购物车服务实现类
 * @createTime 2023年01月31日 21:41:00
 */
@Service
public class CartItemServiceImp implements CartItemService {

    @Resource
    private CartItemRepository cartItemRepository;

    @Override
    public PageResponse<CartItemRes> pageQueryCartItem(CartItemPageQueryReq requestParam) {
        PageResponse<CartItem> cartItemPageResponse = cartItemRepository.pageQueryCartItem(requestParam.getCustomerUserId(), requestParam);
        return cartItemPageResponse.convert(each -> BeanUtil.convert(each, CartItemRes.class));
    }

    @Override
    public List<CartItemRes> getSelectedCartItemInfo(String userId) {
        List<CartItem> cartItems = cartItemRepository.querySelectedCartItem(userId);
        return BeanUtil.convert(cartItems,CartItemRes.class);
    }

    @Override
    public void addCartItem(CartItemAddReq req) {
        CartItem addReq = BeanUtil.convert(req, CartItem.class);
        cartItemRepository.addCartItem(addReq);
    }

    @Override
    public void updateSelectedCartItem(CartItemSelectedReq req) {
        CartItem modifySelecteReq = BeanUtil.convert(req, CartItem.class);
        cartItemRepository.updateSelectedCartItem(modifySelecteReq);
    }


    @Override
    public void updateCartItemNum(CartItemNumReq req) {
        CartItem cartItem = BeanUtil.convert(req, CartItem.class);
        cartItemRepository.updateCartItem(cartItem);
    }

    @Override
    public void clearCartItem(CartItemClearReq requestParam) {
        CartItem cartItem = BeanUtil.convert(requestParam, CartItem.class);
        cartItemRepository.clearCartItem(cartItem);
    }
}
