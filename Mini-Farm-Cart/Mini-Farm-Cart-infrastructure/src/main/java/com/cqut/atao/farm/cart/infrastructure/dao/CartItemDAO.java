package com.cqut.atao.farm.cart.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.cart.domain.mode.req.CartItemNumReq;
import com.cqut.atao.farm.cart.domain.mode.req.CartItemSelectedReq;
import com.cqut.atao.farm.cart.infrastructure.po.CartItem;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CartItemDAO.java
 * Description 商品购物车数据库访问类
 * @createTime 2023年01月31日 21:23:00
 */
public interface CartItemDAO extends BaseMapper<CartItem> {

    @Update("UPDATE cart_item SET product_quantity=#{productQuantity} WHERE id=#{id} AND del_flag=0")
    int updateCartItemNum(CartItemNumReq req);

    @Update("UPDATE cart_item SET select_flag=#{selectFlag} WHERE id=#{id} AND del_flag=0")
    int updateCartItemSelected(CartItemSelectedReq req);

}
