package com.cqut.atao.farm.product.test;

import com.cqut.atao.farm.product.application.req.SearchProductReq;
import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.application.service.ProductCategoryMange;
import com.cqut.atao.farm.product.application.service.ProductMange;
import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.infrastructure.es.EsProductDAO;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSpuDAO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSpuPO;
import com.cqut.atao.farm.product.web.ProductApplication;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description API 测试
 * @createTime 2023年01月30日 20:08:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
public class ApiTest {

    @Resource
    private ProductMange productService;

    @Resource
    private ProductCategoryMange productCategoryService;

    @Resource
    private ProductSpuDAO productSpuDAO;

    @Resource
    private EsProductDAO esProductDAO;

    @Test
    public void insertProductIntoEs() {
        List<ProductSpuPO> productSpuPOS = productSpuDAO.selectList(null);
        for (ProductSpuPO productSpuPO: productSpuPOS) {
            EsProduct convert = BeanUtil.convert(productSpuPO, EsProduct.class);
            log.info("====>{}",convert);
            esProductDAO.save(convert);
        }
    }

    @Test
    public void searcher() {
        SearchProductReq searchProductReq = new SearchProductReq();
        searchProductReq.setKeyword("5G");
        searchProductReq.setCurrent(1L);
        searchProductReq.setSize(10L);
        PageResponse<ProductProfileRes> productProfileResPageResponse = productService.searchProduct(searchProductReq);
        log.info("==========={}",productProfileResPageResponse);
    }

    @Test
    public void test() {
        Long spuId = 1477055850256982016l;
        log.info("根据spuId查找商品->{}",productSpuDAO.selectById(spuId));
    }

    @Test
    public void get() {
        Long spuId = 1477055850256982016l;
        log.info("根据spuId查找商品->{}",productService.getProductBySpuId(spuId));
    }

    @Test
    public void listOfProductCategory(){
        log.info("商品类别列表->{}",productCategoryService.listAllProductCategory());
    }



}
