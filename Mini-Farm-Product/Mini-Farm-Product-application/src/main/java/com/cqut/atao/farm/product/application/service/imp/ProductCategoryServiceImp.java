package com.cqut.atao.farm.product.application.service.imp;

import com.cqut.atao.farm.product.application.res.ProductCategoryRes;
import com.cqut.atao.farm.product.application.service.ProductCategoryService;
import com.cqut.atao.farm.product.domain.mode.aggregate.ProductCategory;
import com.cqut.atao.farm.product.domain.repository.ProductCategoryRepository;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategoryServiceImp.java
 * @Description 商品类别服务实现类
 * @createTime 2023年01月31日 20:01:00
 */
@Slf4j
@Service
public class ProductCategoryServiceImp implements ProductCategoryService {

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategoryRes> listAllProductCategory() {
        ProductCategory productCategory = productCategoryRepository.listAllProductCategory();
        return BeanUtil.convert(productCategory.getProductCategoryList(),ProductCategoryRes.class);
    }
}
