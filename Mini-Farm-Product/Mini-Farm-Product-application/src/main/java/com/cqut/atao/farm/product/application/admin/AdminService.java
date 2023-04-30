package com.cqut.atao.farm.product.application.admin;

import com.cqut.atao.farm.product.domain.mode.aggregate.ProductCategory;
import com.cqut.atao.farm.product.domain.mode.vo.ProductCategoryVO;
import com.cqut.atao.farm.product.domain.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AdminService.java
 * @Description 管理服务
 * @createTime 2023年04月29日 20:06:00
 */
@Service
public class AdminService {

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    public void addProductCategory(ProductCategoryVO productCategory) {
        productCategoryRepository.addProductCategory(productCategory);
    }

    public void delProductCategory(Long id) {
        productCategoryRepository.delProductCategory(id);
    }

    public void updateProductCategory(ProductCategoryVO productCategory) {
        productCategoryRepository.updateProductCategory(productCategory);
    }

    public List<ProductCategoryVO> productCategoryList() {
        return productCategoryRepository.ProductCategorylist();
    }

    public ProductCategoryVO productCategoryDetail(Long id) {
        return productCategoryRepository.productCategoryDetail(id);
    }
}
