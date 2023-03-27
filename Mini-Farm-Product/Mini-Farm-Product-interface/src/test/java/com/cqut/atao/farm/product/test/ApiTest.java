package com.cqut.atao.farm.product.test;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cqut.atao.farm.product.application.req.SearchProductReq;
import com.cqut.atao.farm.product.application.res.ProductProfileRes;
import com.cqut.atao.farm.product.application.service.ProductCategoryMange;
import com.cqut.atao.farm.product.application.service.ProductMange;
import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderItemInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSkuVO;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSkuDAO;
import com.cqut.atao.farm.product.infrastructure.es.EsProductDAO;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSpuDAO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSkuPO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSpuPO;
import com.cqut.atao.farm.product.test.model.ProductSkuTest;
import com.cqut.atao.farm.product.test.model.ProductSpuTest;
import com.cqut.atao.farm.product.web.ProductApplication;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    private ProductSkuDAO productSkuDAO;

    @Resource
    private EsProductDAO esProductDAO;

    @Resource
    private ProductMange productMange;

    @Test
    public void deleteProductIntoEs() {
        esProductDAO.deleteAll();
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

    @Test
    public void lockStock(){
        OrderItemInfo orderItemInfo = OrderItemInfo.builder()
                .num(1)
                .skuId(1477056250724933632L)
                .build();
        List<OrderItemInfo> list = new ArrayList<>();
        list.add(orderItemInfo);

        OrderInfo orderInfo = OrderInfo.builder()
                .orderNo("")
                .orderItemInfos(list)
                .build();
        productService.lockProductStock(orderInfo);
    }


    @Test
    public void insertProductIntoEs() {
        esProductDAO.deleteAll();
        List<ProductSpuPO> productSpuPOS = productSpuDAO.selectList(Wrappers.lambdaQuery(ProductSpuPO.class).between(ProductSpuPO::getCategoryId,100,120));
        for (ProductSpuPO productSpuPO: productSpuPOS) {
            EsProduct convert = BeanUtil.convert(productSpuPO, EsProduct.class);
            log.info("====>{}",convert);
            esProductDAO.save(convert);
        }
    }

    @Test
//    @Transactional
    public void  testFile() throws IOException {
        String filePath = "/Users/weitao/Desktop/毕业设计/项目/爬虫/goodsItem/data/yml.txt";
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        while((strTmp = buffReader.readLine())!=null){
            Object parse = JSON.parse(strTmp);
            ProductSpuTest spu = BeanUtil.convert(parse, ProductSpuTest.class);
            // 清洗数据
            spu = clear(spu);

            spu.setProductSn(UUID.randomUUID().toString());
            ProductSpuPO spuPO = BeanUtil.convert(spu, ProductSpuPO.class);
            productSpuDAO.insert(spuPO);
            List<ProductSkuTest> skus = spu.getSkus();
            skus.forEach(e->{
                e = clear(e);
                ProductSkuPO skuPO = BeanUtil.convert(e, ProductSkuPO.class);
                productSkuDAO.insert(skuPO);
            });
        }
        buffReader.close();
    }

    @Transactional
    public void insert(String jsonStr) {
        Object parse = JSON.parse(jsonStr);
        ProductSpuTest spu = BeanUtil.convert(parse, ProductSpuTest.class);
        // 清洗数据
        spu = clear(spu);

        spu.setProductSn(UUID.randomUUID().toString());
        ProductSpuPO spuPO = BeanUtil.convert(spu, ProductSpuPO.class);
        productSpuDAO.insert(spuPO);
        List<ProductSkuTest> skus = spu.getSkus();
        skus.forEach(e->{
            e = clear(e);
            ProductSkuPO skuPO = BeanUtil.convert(e, ProductSkuPO.class);
            productSkuDAO.insert(skuPO);
        });
        log.warn("成功");
    }

    public ProductSpuTest clear(ProductSpuTest item) {

        if (item.getName().length() > 2) {
            item.setName(item.getName().substring(2,item.getName().length()-2));
        }
        if (item.getPic().length() > 2) {
            item.setPic(item.getPic().substring(2, item.getPic().length() - 2));
        }
        if (item.getSubTitle().length() > 2) {
            item.setSubTitle(item.getSubTitle().substring(2, item.getSubTitle().length() - 2));
        }
        if (item.getDetail().length() > 3) {
            item.setDetail(item.getDetail().substring(3, item.getDetail().length() - 3));
        }
        // 服务
        if (item.getDetailService().length() > 1) {
            String[] s = item.getDetailService().substring(1, item.getDetailService().length() - 1).split(",");
            String ser = "";
            for (String service : s) {
                if (service.length() > 1) {
                    ser = ser + service.substring(1, service.length() - 1);
                }
            }
            item.setDetailService(ser);
        }
        // 轮播图
        if (item.getPhotoAlbum().length() > 1) {
            String[] pic = item.getPhotoAlbum().substring(1,item.getPhotoAlbum().length()-1).split(",");
            String res = "";
            for (String p: pic) {
                if (res.length() == 0) {
                    if (p.length() > 1) {
                        res = p.substring(1, p.length() - 1);
                    }
                    continue;
                }
                if (p.length() > 1) {
                    res = res + ";" + p.substring(1, p.length() - 1);
                }
            }
            item.setPhotoAlbum(res);
        }
        // 详情图片
        if (item.getDetailPic().length() > 1) {
            String[] pic = item.getDetailPic().substring(1, item.getDetailPic().length() - 1).split(",");
            String res = "";
            for (String p : pic) {
                if (res.length() == 0) {
                   if (p.length() > 1) {
                       res = p.substring(1, p.length() - 1);
                   }
                    continue;
                }
                if (p.length() > 1) {
                    res = res + ";" + p.substring(1, p.length() - 1);
                }
            }
            item.setDetailPic(res);
        }
        return item;
    }

    public ProductSkuTest clear(ProductSkuTest item) {
        if (item.getPic().length() > 2) {
            item.setPic(item.getPic().substring(2, item.getPic().length() - 2));
        }
//        if (item.getAttribute().length() > 1) {
//            item.setAttribute(item.getAttribute().substring(1, item.getAttribute().length() - 1));
//        }
        return item;
    }

    @Test
    public void find() {
        Optional<EsProduct> byId = esProductDAO.findById("716");
        log.info(byId.toString());
    }



    @Test
    public void updateProductInfo() {
        ProductSpuPO productSpuPO = productSpuDAO.selectById("716");
        log.warn("spu:{}",productSpuPO);
        List<ProductSkuPO> productSkuPOS = productSkuDAO.selectList(Wrappers.lambdaQuery(ProductSkuPO.class).eq(ProductSkuPO::getProductId, "716"));
        log.warn("sku:{}",productSkuPOS);

        Product product = Product.builder()
                .productSpu(BeanUtil.convert(productSpuPO, ProductSpuVO.class))
                .productSkus(BeanUtil.convert(productSkuPOS, ProductSkuVO.class))
                .build();
        product.getProductSpu().setSales(792);

        log.warn("product:{}",product);

        productMange.updateProductInfo(product);


    }





}
