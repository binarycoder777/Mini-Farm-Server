package com.cqut.atao.farm.product.application.service;

import com.cqut.atao.farm.product.domain.mode.req.UserFoot;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductFootMange.java
 * @Description 用户足迹
 * @createTime 2023年04月14日 16:12:00
 */
public interface ProductFootMange {
    List<ProductSpuVO> productFootList(Long userId);

    void addUserFoot(UserFoot foot);

    void deleteUserFoot(UserFoot foot);
}
