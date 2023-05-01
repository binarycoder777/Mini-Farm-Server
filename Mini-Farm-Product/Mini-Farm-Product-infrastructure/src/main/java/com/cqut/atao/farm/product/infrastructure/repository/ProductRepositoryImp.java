package com.cqut.atao.farm.product.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderItemInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.req.BatchQueryReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductBrandVO;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSkuVO;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.domain.repository.ProductRepository;
import com.cqut.atao.farm.product.infrastructure.dao.ProductBrandDAO;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSkuDAO;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSpuDAO;
import com.cqut.atao.farm.product.infrastructure.es.EsProductDAO;
import com.cqut.atao.farm.product.infrastructure.po.ProductBrandPO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSkuPO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSpuPO;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductRepositoryImp.java
 * @Description 商品存储实现类
 * @createTime 2023年01月30日 19:47:00
 */
@Slf4j
@Repository
public class ProductRepositoryImp implements ProductRepository {

    @Resource
    private ProductSpuDAO productSpuDAO;

    @Resource
    private ProductBrandDAO productBrandDAO;

    @Resource
    private ProductSkuDAO productSkuDAO;

    @Resource
    private ThreadPoolExecutor productThreadPoolExecutor;

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Resource
    private EsProductDAO esProductDAO;


    @Override
    @SneakyThrows
    public Product getProductBySpuId(Long spuId) {
        ProductSpuPO productSpuPO = productSpuDAO.selectById(spuId);
        Future<ProductBrandPO> productBrandDOFuture = productThreadPoolExecutor
                .submit(() -> productBrandDAO.selectById(productSpuPO.getBrandId()));
        Future<List<ProductSkuPO>> productSkuDOListFuture = productThreadPoolExecutor
                .submit(() -> productSkuDAO.selectList(Wrappers.lambdaQuery(ProductSkuPO.class).eq(ProductSkuPO::getProductId, spuId)));
        Product product = Product.builder()
                .productBrand(BeanUtil.convert(productBrandDOFuture.get(), ProductBrandVO.class))
                .productSpu(BeanUtil.convert(productSpuPO, ProductSpuVO.class))
                .productSkus(BeanUtil.convert(productSkuDOListFuture.get(), ProductSkuVO.class))
                .build();
        return product;
    }

    @Override
    public PageResponse<ProductSpuVO> searchProductByCategoryId(PageRequest pageRequest, Long categoryId) {
        LambdaQueryWrapper<ProductSpuPO> queryWrapper = Wrappers.lambdaQuery(ProductSpuPO.class).eq(ProductSpuPO::getCategoryId, categoryId);
        Page page = productSpuDAO.selectPage(new Page(pageRequest.getCurrent(), pageRequest.getSize()), queryWrapper);
        PageResponse productPageResponse = PageResponse.builder()
                .current(page.getCurrent())
                .size(page.getSize())
                .total(page.getTotal())
                .records(page.getRecords())
                .build();
        return productPageResponse.convert(e -> BeanUtil.convert(e, ProductSpuVO.class));
    }

    @Override
    public PageResponse<ProductSpuVO> searchProductByCategoryId(PageRequest pageRequest, Long categoryId, Integer sortSales, Integer sortPrice) {
        LambdaQueryWrapper<ProductSpuPO> queryWrapper = Wrappers.lambdaQuery(ProductSpuPO.class).eq(ProductSpuPO::getCategoryId, categoryId);
        // 排序条件
        if (sortSales == 0) {
            queryWrapper.orderByDesc(ProductSpuPO::getSales);
        } else {
            queryWrapper.orderByAsc(ProductSpuPO::getSales);
        }
        if (sortPrice == 0) {
            queryWrapper.orderByDesc(ProductSpuPO::getPrice);
        } else {
            queryWrapper.orderByAsc(ProductSpuPO::getPrice);
        }
        Page page = productSpuDAO.selectPage(new Page(pageRequest.getCurrent(), pageRequest.getSize()), queryWrapper);
        PageResponse productPageResponse = PageResponse.builder()
                .current(page.getCurrent())
                .size(page.getSize())
                .total(page.getTotal())
                .records(page.getRecords())
                .build();
        return productPageResponse.convert(e -> BeanUtil.convert(e, ProductSpuVO.class));

    }

    @Override
    public PageResponse<EsProduct> searchProductInfo(PageRequest pageRequest, String keyword) {
        // 查询条件
        MultiMatchQueryBuilder matchAllQueryBuilder = QueryBuilders.multiMatchQuery(keyword, "name", "subTitle");
        // 分页条件
        Pageable pageable = org.springframework.data.domain.PageRequest.of(Integer.parseInt("" + (pageRequest.getCurrent() - 1)), Integer.parseInt("" + pageRequest.getSize()));
        // 构建请求
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(matchAllQueryBuilder)
                .withPageable(pageable)
                .build();
        // 进行查询
        SearchHits<EsProduct> search = elasticsearchRestTemplate.search(query, EsProduct.class);
        List<EsProduct> collect = search.get()
                .map(SearchHit::getContent).collect(Collectors.toList());
        // 返回结果
        return new PageResponse<EsProduct>(pageRequest.getCurrent(), pageRequest.getSize(), search.getTotalHits(), collect);
    }

    @Override
    public PageResponse<EsProduct> searchProductInfo(PageRequest pageRequest, String keyword, Integer sortPrice, Integer sortSales) {
        // 查询条件
        MultiMatchQueryBuilder matchAllQueryBuilder = QueryBuilders.multiMatchQuery(keyword, "name", "subTitle");
        // 分页条件
        Pageable pageable = org.springframework.data.domain.PageRequest.of(Integer.parseInt("" + (pageRequest.getCurrent() - 1)), Integer.parseInt("" + pageRequest.getSize()));
        // 排序
//        FieldSortBuilder priceSort = null;
//        if (sortPrice == 0) {
//            priceSort = SortBuilders.fieldSort("price").order(SortOrder.DESC);
//        } else {
//            priceSort = SortBuilders.fieldSort("price").order(SortOrder.ASC);
//        }
//        FieldSortBuilder salesSort = null;
//        if (sortSales == 0) {
//            salesSort = SortBuilders.fieldSort("sales").order(SortOrder.DESC);
//        } else {
//            salesSort = SortBuilders.fieldSort("sales").order(SortOrder.ASC);
//        }
        // 构建请求
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(matchAllQueryBuilder)
//                .withSort(priceSort)
//                .withSort(salesSort)
                .withPageable(pageable)
                .build();
        // 进行查询
        log.error("{}=>{}",pageable.getPageNumber(),pageable.getPageSize());
        SearchHits<EsProduct> search = elasticsearchRestTemplate.search(query, EsProduct.class);
        List<EsProduct> collect = search.get()
                .map(SearchHit::getContent).collect(Collectors.toList());
        // 返回结果
        return new PageResponse<EsProduct>(pageRequest.getCurrent(), pageRequest.getSize(), search.getTotalHits(), collect);
    }

    @Override
    public void lockProductStock(OrderInfo orderInfo) {
        for (OrderItemInfo itemInfo : orderInfo.getOrderItemInfos()) {
            int res = productSkuDAO.lockStock(itemInfo);
            Assert.isTrue(res > 0, () -> new ServiceException("锁定库存失败"));
        }
    }

    @Override
    public void unlockProductStock(OrderInfo orderInfo) {
        for (OrderItemInfo itemInfo : orderInfo.getOrderItemInfos()) {
            int res = productSkuDAO.unlockStock(itemInfo);
            Assert.isTrue(res > 0, () -> new ServiceException("锁定库存失败"));
        }
    }

    @Override
    public BigDecimal checkProductAmount(List<Long> skuList) {
        BigDecimal payAmount = new BigDecimal("0");
        for (Long skuId : skuList) {
            ProductSkuPO productSkuPO = productSkuDAO.selectById(skuId);
            payAmount = payAmount.add(productSkuPO.getPrice());
        }
        log.info("核验金额------>{}", payAmount);
        return payAmount;
    }

    @Override
    @Transactional
    public void updateProductInfo(Product req) {
        // spu
        ProductSpuVO productSpu = req.getProductSpu();
        ProductSpuPO spuPO = BeanUtil.convert(productSpu, ProductSpuPO.class);
        productSpuDAO.updateById(spuPO);
        // sku
        List<ProductSkuVO> productSkus = req.getProductSkus();
        List<ProductSkuPO> productSkuPOS = BeanUtil.convert(productSkus, ProductSkuPO.class);
        productSkuPOS.forEach(skuPO -> {
            productSkuDAO.updateById(skuPO);
        });
        // brand (暂未加入brand)
//        ProductBrandVO productBrand = req.getProductBrand();
//        ProductBrandPO productBrandPO = BeanUtil.convert(productBrand, ProductBrandPO.class);
//        productBrandDAO.updateById(productBrandPO);
    }

    @Override
    public void saveEsProduct(EsProduct esProduct) {
        esProductDAO.deleteById(esProduct.getId()+"");
        esProductDAO.save(esProduct);
    }

    @Override
    public List<Product> queryProductList(List<BatchQueryReq> spuIdList) {
        ArrayList<Product> res = Lists.newArrayList();
        for (BatchQueryReq req: spuIdList) {
            ProductSpuPO productSpuPO = productSpuDAO.selectById(req.getProductId());
            ProductSkuPO productSkuPO = productSkuDAO.selectById(req.getProductSkuId());
            ArrayList<ProductSkuVO> list = Lists.newArrayList();
            list.add(BeanUtil.convert(productSkuPO,ProductSkuVO.class));
            Product build = Product.builder()
                    .productSpu(BeanUtil.convert(productSpuPO, ProductSpuVO.class))
                    .productSkus(list)
                    .build();
            res.add(build);
        }
        return res;
    }

    @Transactional
    @Override
    public ProductSpuVO addProductInfo(Product req) {
        // spu
        ProductSpuVO productSpu = req.getProductSpu();
        ProductSpuPO spuPO = BeanUtil.convert(productSpu, ProductSpuPO.class);
        String uuid = UUID.randomUUID().toString();
        spuPO.setProductSn(uuid);
        productSpuDAO.insert(spuPO);

        ProductSpuPO productSpuPO = productSpuDAO.selectOne(Wrappers.lambdaQuery(ProductSpuPO.class).eq(ProductSpuPO::getProductSn, uuid));
        // sku
        List<ProductSkuVO> productSkus = req.getProductSkus();
        List<ProductSkuPO> productSkuPOS = BeanUtil.convert(productSkus, ProductSkuPO.class);
        productSkuPOS.forEach(skuPO -> {
            skuPO.setProductId(productSpuPO.getId());
            productSkuDAO.insert(skuPO);
        });
        return BeanUtil.convert(productSpuPO,ProductSpuVO.class);
    }

    @Override
    @Transactional
    public void deleteProductInfo(Long id) {
        productSpuDAO.deleteById(id);
        productSkuDAO.delete(Wrappers.lambdaQuery(ProductSkuPO.class).eq(ProductSkuPO::getProductId,id));
    }

    @Override
    public void deleteEsProduct(Long id) {
        esProductDAO.deleteById(id+"");
    }
}
