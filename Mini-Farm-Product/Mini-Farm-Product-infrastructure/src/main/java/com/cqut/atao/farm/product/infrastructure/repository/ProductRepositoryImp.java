package com.cqut.atao.farm.product.infrastructure.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.vo.ProductBrandVO;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSkuVO;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.domain.repository.ProductRepository;
import com.cqut.atao.farm.product.infrastructure.dao.ProductBrandDAO;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSkuDAO;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSpuDAO;
import com.cqut.atao.farm.product.infrastructure.po.ProductBrandPO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSkuPO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSpuPO;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import lombok.SneakyThrows;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
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
    public PageResponse<EsProduct> searchProductInfo(PageRequest pageRequest, String keyword) {
        // 查询条件
        MultiMatchQueryBuilder matchAllQueryBuilder = QueryBuilders.multiMatchQuery(keyword,"name","subTitle");
        // 分页条件
        Pageable pageable= org.springframework.data.domain.PageRequest.of(Integer.parseInt(""+(pageRequest.getCurrent()-1)),Integer.parseInt(""+pageRequest.getSize()));
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
        return new PageResponse<EsProduct>(pageRequest.getCurrent(),pageRequest.getSize(),search.getTotalHits(),collect);
    }

}
