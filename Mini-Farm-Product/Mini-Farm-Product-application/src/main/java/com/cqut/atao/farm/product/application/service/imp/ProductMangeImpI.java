package com.cqut.atao.farm.product.application.service.imp;

import com.cqut.atao.farm.product.application.req.CheckAmountReq;
import com.cqut.atao.farm.product.application.req.ProductCategoryReq;
import com.cqut.atao.farm.product.application.req.SearchProductReq;
import com.cqut.atao.farm.product.application.res.CheckAmountRes;
import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.application.res.ProductRes;
import com.cqut.atao.farm.product.application.service.ProductMange;
import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.req.BatchQueryReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.domain.mq.event.ProductMessageSendEvent;
import com.cqut.atao.farm.product.domain.mq.produce.ProductProduce;
import com.cqut.atao.farm.product.domain.repository.ProductRepository;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Resource
    private ProductProduce productProduce;


    @Override
    public ProductRes getProductBySpuId(Long spuId) {
        Product product = productRepository.getProductBySpuId(spuId);
        return BeanUtil.convert(product,ProductRes.class);
    }

    @Override
    public PageResponse<ProductProfileRes> searchProduct(SearchProductReq request) {
        PageResponse<EsProduct> esProductPageResponse = productRepository.searchProductInfo(request,request.getKeyword(),request.getSortPrice(),request.getSortSales());
        return esProductPageResponse.convert(e->BeanUtil.convert(e,ProductProfileRes.class));
    }

    @Override
    public void lockProductStock(OrderInfo orderInfo) {
        productRepository.lockProductStock(orderInfo);
    }

    @Override
    public void unlockProductStock(OrderInfo orderInfo) {
        productRepository.unlockProductStock(orderInfo);
    }

    @Override
    public CheckAmountRes checkProductAmount(CheckAmountReq req) {
        BigDecimal payAmount = productRepository.checkProductAmount(req.getSkuIds());
        return CheckAmountRes.builder().payAmount(payAmount).build();
    }

    @Override
    public PageResponse<ProductProfileRes> getProductByCategoryId(ProductCategoryReq req) {
        PageResponse<ProductSpuVO> productPageResponse = productRepository.searchProductByCategoryId(req, req.getCategoryId(),req.getSortSales(),req.getSortPrice());
        return productPageResponse.convert(e->BeanUtil.convert(e,ProductProfileRes.class));
    }

    @Override
    public void updateProductInfo(Product req) {
        // 修改数据
        productRepository.updateProductInfo(req);
        // MQ异步修改ES数据
        EsProduct esProduct = BeanUtil.convert(req.getProductSpu(), EsProduct.class);
        productRepository.saveEsProduct(esProduct);
//        ProductMessageSendEvent build = ProductMessageSendEvent.builder()
//                .messageSendId(UUID.randomUUID().toString())
//                .esProduct(esProduct)
//                .sendTime(new Date())
//                .build();
//        productProduce.productMessageSend(build);
    }

    @Override
    public List<Product> queryProducts(List<BatchQueryReq> spuIds) {
        return productRepository.queryProductList(spuIds);
    }

    @Override
    public void addProductInfo(Product req) {
        // 修改数据
        ProductSpuVO productSpuVO = productRepository.addProductInfo(req);
        // MQ异步修改ES数据
        EsProduct esProduct = BeanUtil.convert(productSpuVO, EsProduct.class);
        productRepository.saveEsProduct(esProduct);
    }

    @Override
    public void deleteProductInfo(Long id) {
        // 修改数据
        productRepository.deleteProductInfo(id);
        // MQ异步修改ES数据
        productRepository.deleteEsProduct(id);
    }
}
