package com.cqut.atao.farm.cart.application.service.imp;


import com.cqut.atao.farm.cart.application.service.CartItemService;
import com.cqut.atao.farm.cart.domain.mode.req.*;
import com.cqut.atao.farm.cart.domain.mode.res.CartItemRes;
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
    public Long queryCartItemNum(Long userId) {
        return cartItemRepository.queryCartItemNum(userId);
    }

    @Override
    public PageResponse<CartItemRes> pageQueryCartItem(CartItemPageQueryReq requestParam) {
        return cartItemRepository.pageQueryCartItem(requestParam.getUserId(), requestParam);
    }

    @Override
    public List<CartItemRes> getSelectedCartItemInfo(String userId) {
        return cartItemRepository.querySelectedCartItem(userId);
    }

    @Override
    public void addCartItem(CartItemAddReq req) {
        cartItemRepository.addCartItem(req);
    }

    @Override
    public void updateSelectedCartItem(CartItemSelectedReq req) {
        cartItemRepository.updateSelectedCartItem(req);
    }


    @Override
    public void updateCartItemNum(CartItemNumReq req) {
        cartItemRepository.updateCartItem(req);
    }

    @Override
    public void clearCartItem(CartItemClearReq requestParam) {
        cartItemRepository.clearCartItem(requestParam);
    }

    @Override
    public void deleteCartItem(CartItemDeleteReq requestParam) {
        cartItemRepository.deleteCartItem(requestParam);
    }

    @Override
    public void selectedAllCartItem(Long userId) {
        cartItemRepository.selectedAllCartItem(userId);
    }

    @Override
    public void cancelSelectedAllCartItem(Long userId) {
        cartItemRepository.cancelSelectedAllCartItem(userId);
    }
}
