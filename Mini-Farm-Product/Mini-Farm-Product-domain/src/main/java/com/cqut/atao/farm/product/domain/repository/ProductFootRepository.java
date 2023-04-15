package com.cqut.atao.farm.product.domain.repository;

import com.cqut.atao.farm.product.domain.mode.req.UserFoot;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductFootRepository.java
 * @Description 商品足迹
 * @createTime 2023年04月14日 15:29:00
 */
public interface ProductFootRepository {

    /**
     * 新增用户足迹
     * @param foot
     */
    void addUserFoot(UserFoot foot);

    /**
     * 查询足迹
     */
    List<ProductSpuVO> queryUserFoot(Long userId);

    void deleteUserFoot(UserFoot foot);
}
