package com.cqut.atao.farm.product.application.service.imp;

import com.cqut.atao.farm.product.application.req.SearchProductReq;
import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.application.res.ProductRes;
import com.cqut.atao.farm.product.application.service.ProductMange;
import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.repository.ProductRepository;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductServiceImp.java
 * @Description 商品服务类实现
 * @createTime 2023年01月30日 19:30:00
 */
@Slf4j
@Service
public class ProductMangeImpI implements ProductMange {

    @Resource
    private ProductRepository productRepository;


    @Override
    public ProductRes getProductBySpuId(Long spuId) {
        Product product = productRepository.getProductBySpuId(spuId);
        return BeanUtil.convert(product,ProductRes.class);
    }

    @Override
    public PageResponse<ProductProfileRes> searchProduct(SearchProductReq request) {
        PageResponse<EsProduct> esProductPageResponse = productRepository.searchProductInfo(request,request.getKeyword());
        return esProductPageResponse.convert(e->BeanUtil.convert(e,ProductProfileRes.class));
    }
}
