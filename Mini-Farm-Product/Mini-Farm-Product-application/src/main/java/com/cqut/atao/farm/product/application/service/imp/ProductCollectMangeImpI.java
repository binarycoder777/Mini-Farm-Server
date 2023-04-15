package com.cqut.atao.farm.product.application.service.imp;

import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.application.service.ProductCollectMange;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.req.CollectProductReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCollectProductReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.domain.repository.ProductCollectRepository;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCollectMangeImpI.java
 * @Description 商品收藏管理
 * @createTime 2023年04月10日 22:07:00
 */
@Service
public class ProductCollectMangeImpI implements ProductCollectMange {

    @Resource
    private ProductCollectRepository productCollectRepository;


    @Override
    public void collecteProduct(CollectProductReq req) {
        productCollectRepository.save(req);
    }

    @Override
    public boolean getProductCollectStatus(Long userId, Long productId) {
        return productCollectRepository.queryProductCollectStatus(userId,productId);
    }

    @Override
    public PageResponse<ProductSpuVO> pageQueryProductCollect(PageCollectProductReq req) {
        return productCollectRepository.queryCollectProduct(req);
    }
}
