package com.cqut.atao.farm.product.application.service.imp;

import com.cqut.atao.farm.product.application.res.ProductCategoryRes;
import com.cqut.atao.farm.product.application.service.ProductCategoryMange;
import com.cqut.atao.farm.product.domain.mode.aggregate.ProductCategory;
import com.cqut.atao.farm.product.domain.mode.vo.ProductCategoryVO;
import com.cqut.atao.farm.product.domain.repository.ProductCategoryRepository;
import com.cqut.atao.farm.product.infrastructure.po.ProductCategoryPO;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
public class ProductCategoryMangeImpI implements ProductCategoryMange {

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategoryRes> listAllProductCategory() {
        List<ProductCategoryVO> productCategoryList = productCategoryRepository.listAllProductCategory().getProductCategoryList();
        // 构建树形节点
        HashMap<Long, ProductCategoryVO> map = Maps.newHashMap();
        List<ProductCategoryVO> parentList = Lists.newArrayList();
        for (ProductCategoryVO e: productCategoryList) {
            if (e.getParentId() == 0) {
                map.put(e.getId(),e);
                parentList.add(e);
            }
        }
        for (ProductCategoryVO e: productCategoryList) {
            if (e.getParentId() == 0) {
                continue;
            }
            // 获取父节点
            ProductCategoryVO parent = map.get(e.getParentId());
            // 子节点加入父节点
            if (parent.getChild() == null) {
                parent.setChild(Lists.newArrayList());
            }
            parent.getChild().add(e);
        }

        return BeanUtil.convert(parentList,ProductCategoryRes.class);
    }
}
