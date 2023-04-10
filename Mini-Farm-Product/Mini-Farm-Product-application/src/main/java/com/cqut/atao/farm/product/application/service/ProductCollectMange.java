package com.cqut.atao.farm.product.application.service;

import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.req.CollectProductReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCollectProductReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCollectMange.java
 * @Description 商品收藏关了
 * @createTime 2023年04月10日 22:07:00
 */
public interface ProductCollectMange {

    /**
     * 用户收藏/取消收藏商品请求
     * @param req {@link CollectProductReq}
     */
    void collecteProduct(CollectProductReq req);

    /**
     * 获取收藏商品状态
     * @param userId 用户id
     * @param productId 商品id
     * @return true/false
     */
    boolean getProductCollectStatus(Long userId,Long productId);

    /**
     * 分页查询收藏商品
     * @param req
     * @return
     */
    PageResponse<ProductSpuVO> pageQueryProductCollect(PageCollectProductReq req);

}
