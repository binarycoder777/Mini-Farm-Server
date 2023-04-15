package com.cqut.atao.farm.product.domain.repository;

import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.req.CollectProductReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCollectProductReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCollectRepository.java
 * @Description 商品收藏仓储接口
 * @createTime 2023年04月10日 22:05:00
 */
public interface ProductCollectRepository {
    void save(CollectProductReq req);

    boolean queryProductCollectStatus(Long userId, Long productId);

    PageResponse<ProductSpuVO> queryCollectProduct(PageCollectProductReq req);
}
