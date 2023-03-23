package com.cqut.atao.farm.product.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cqut.atao.farm.product.domain.mode.aggregate.ProductCategory;
import com.cqut.atao.farm.product.domain.mode.vo.ProductCategoryVO;
import com.cqut.atao.farm.product.domain.repository.ProductCategoryRepository;
import com.cqut.atao.farm.product.infrastructure.dao.ProductCategoryDAO;
import com.cqut.atao.farm.product.infrastructure.po.ProductCategoryPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategoryRepositoryImp.java
 * @Description 商品类别存储层实现类
 * @createTime 2023年01月31日 20:09:00
 */
@Repository
public class ProductCategoryRepositoryImp implements ProductCategoryRepository {

    @Resource
    private ProductCategoryDAO productCategoryDAO;

    @Override
    public ProductCategory listAllProductCategory() {
        List<ProductCategoryPO> productCategoryPOS = productCategoryDAO.selectList(Wrappers.lambdaQuery(ProductCategoryPO.class).eq(ProductCategoryPO::getStatus, 0));
        return ProductCategory.builder().productCategoryList(BeanUtil.copyToList(productCategoryPOS, ProductCategoryVO.class)).build();
    }
}
