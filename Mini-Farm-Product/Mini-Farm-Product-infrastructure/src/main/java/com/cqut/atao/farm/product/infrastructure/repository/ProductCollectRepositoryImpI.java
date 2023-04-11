package com.cqut.atao.farm.product.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import com.cqut.atao.farm.product.domain.mode.req.CollectProductReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCollectProductReq;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSkuVO;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.domain.repository.ProductCollectRepository;
import com.cqut.atao.farm.product.infrastructure.dao.ProductCollectionDao;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSpuDAO;
import com.cqut.atao.farm.product.infrastructure.po.ProductCollectionPO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSkuPO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSpuPO;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCollectRepository.java
 * @Description 商品收藏仓储层
 * @createTime 2023年04月10日 22:03:00
 */
@Repository
public class ProductCollectRepositoryImpI implements ProductCollectRepository {

    @Resource
    private ProductCollectionDao productCollectionDao;

    @Resource
    private ProductSpuDAO productSpuDAO;

    @Override
    public void save(CollectProductReq req) {
        // 不存在
        if (!productCollectionDao.exists(Wrappers.lambdaQuery(ProductCollectionPO.class)
                .eq(ProductCollectionPO::getUserId,req.getUserId())
                .eq(ProductCollectionPO::getProductId,req.getProductId()))) {
            // 新增
            productCollectionDao.insert(BeanUtil.convert(req,ProductCollectionPO.class));
            return;
        }
        // 修改
        productCollectionDao.update(BeanUtil.convert(req,ProductCollectionPO.class),Wrappers.lambdaQuery(ProductCollectionPO.class)
                .eq(ProductCollectionPO::getUserId,req.getUserId())
                .eq(ProductCollectionPO::getProductId,req.getProductId()));
    }

    @Override
    public boolean queryProductCollectStatus(Long userId, Long productId) {
        ProductCollectionPO productCollectionPO = productCollectionDao.selectOne(Wrappers.lambdaQuery(ProductCollectionPO.class)
                .eq(ProductCollectionPO::getUserId, userId)
                .eq(ProductCollectionPO::getProductId, productId));
        if (productCollectionPO == null) {
            return false;
        }
        return productCollectionPO.isStatus();
    }

    @Override
    public PageResponse<ProductSpuVO> queryCollectProduct(PageCollectProductReq req) {
        // 查询收藏的商品记录
        Page<ProductCollectionPO> page = new Page<>(req.getCurrent(),req.getSize());
        LambdaQueryWrapper<ProductCollectionPO> eq = Wrappers.lambdaQuery(ProductCollectionPO.class)
                .eq(ProductCollectionPO::getUserId, req.getUserId())
                .eq(ProductCollectionPO::isStatus,1);
        Page<ProductCollectionPO> productCollectionPOPage = productCollectionDao.selectPage(page, eq);
        List<ProductCollectionPO> records = productCollectionPOPage.getRecords();
                // 根据记录查询商品信息
        List<ProductSpuPO> spuPOS = Lists.newArrayList();
        records.forEach(e->{
            ProductSpuPO productSpuPO = productSpuDAO.selectById(e.getProductId());
            spuPOS.add(productSpuPO);
        });
        Page<ProductSpuPO> res = new Page<ProductSpuPO>(productCollectionPOPage.getCurrent(),productCollectionPOPage.getSize(),productCollectionPOPage.getTotal());
        res.setRecords(spuPOS);
        return PageUtil.convert(res, ProductSpuVO.class);
    }
}
