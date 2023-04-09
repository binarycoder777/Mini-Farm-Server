package com.cqut.atao.farm.product.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.product.domain.mode.req.AddCommentReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCommentReq;
import com.cqut.atao.farm.product.domain.mode.res.CommentRes;
import com.cqut.atao.farm.product.domain.mode.res.CommentStatisticsRes;
import com.cqut.atao.farm.product.domain.repository.ProductCommentRepository;
import com.cqut.atao.farm.product.infrastructure.dao.ProductCommentDAO;
import com.cqut.atao.farm.product.infrastructure.po.ProductCommentPO;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCommentRepositoryImpI.java
 * @Description 商品评论仓储实现类
 * @createTime 2023年04月08日 13:55:00
 */
@Slf4j
@Repository
public class ProductCommentRepositoryImpI implements ProductCommentRepository {

    @Resource
    private ProductCommentDAO productCommentDAO;

    @Override
    public void addComment(AddCommentReq req) {
        ProductCommentPO productCommentPO = BeanUtil.convert(req, ProductCommentPO.class);
        int insert = productCommentDAO.insert(productCommentPO);
        Assert.isTrue(insert > 0, () -> new ServiceException("评论异常"));
    }

    @Override
    public CommentStatisticsRes queryAllCommentStatistics(Long productSpuId) {
        Long count = productCommentDAO.selectCount(Wrappers.lambdaQuery(ProductCommentPO.class)
                .eq(ProductCommentPO::getProductId, productSpuId));
        return CommentStatisticsRes.builder()
                .name("所有评论")
                .type("all")
                .number(count).build();
    }

    @Override
    public CommentStatisticsRes queryGoodCommentStatistics(Long productSpuId) {
        Long count = productCommentDAO.selectCount(Wrappers.lambdaQuery(ProductCommentPO.class)
                .eq(ProductCommentPO::getProductId, productSpuId)
                .gt(ProductCommentPO::getStar, 3));
        return CommentStatisticsRes.builder()
                .name("好评")
                .type("good")
                .number(count).build();
    }

    @Override
    public CommentStatisticsRes querySecondaryCommentStatistics(Long productSpuId) {
        Long count = productCommentDAO.selectCount(Wrappers.lambdaQuery(ProductCommentPO.class)
                .eq(ProductCommentPO::getProductId, productSpuId)
                .eq(ProductCommentPO::getStar, 3));
        return CommentStatisticsRes.builder()
                .name("中评")
                .type("all")
                .number(count).build();
    }

    @Override
    public CommentStatisticsRes queryPoorCommentStatistics(Long productSpuId) {
        Long count = productCommentDAO.selectCount(Wrappers.lambdaQuery(ProductCommentPO.class)
                .eq(ProductCommentPO::getProductId, productSpuId)
                .lt(ProductCommentPO::getStar, 3));
        return CommentStatisticsRes.builder()
                .name("差评")
                .type("poor")
                .number(count).build();
    }

    @Override
    public CommentStatisticsRes queryImgCommentStatistics(Long productSpuId) {
        Long count = productCommentDAO.selectCount(Wrappers.lambdaQuery(ProductCommentPO.class)
                .eq(ProductCommentPO::getProductId, productSpuId)
                .isNotNull(ProductCommentPO::getPics));
        return CommentStatisticsRes.builder()
                .number(count)
                .name("带图")
                .type("img")
                .build();
    }

    @Override
    public CommentStatisticsRes queryVideoCommentStatistics(Long productSpuId) {
        Long count = productCommentDAO.selectCount(Wrappers.lambdaQuery(ProductCommentPO.class)
                .eq(ProductCommentPO::getProductId, productSpuId)
                .isNotNull(ProductCommentPO::getVideo));
        return CommentStatisticsRes.builder().number(count)
                .name("带视频")
                .type("video")
                .build();
    }

    @Override
    public CommentStatisticsRes queryAppendCommentStatistics(Long productSpuId) {
        Long count = productCommentDAO.selectCount(Wrappers.lambdaQuery(ProductCommentPO.class)
                .eq(ProductCommentPO::getProductId, productSpuId)
                .eq(ProductCommentPO::getType, 6));
        return CommentStatisticsRes.builder().number(count).build();
    }

    @Override
    public PageResponse<CommentRes> pageQueryComment(PageCommentReq req) {
        Page<ProductCommentPO> page = new Page<>(req.getCurrent(), req.getSize());
        LambdaQueryWrapper<ProductCommentPO> eq = null;
        if (req.getType() == 0) {
            Wrappers.lambdaQuery(ProductCommentPO.class)
                    .eq(ProductCommentPO::getProductId, req.getProductSpuId());
        } else {
            Wrappers.lambdaQuery(ProductCommentPO.class)
                    .eq(ProductCommentPO::getType, req.getType())
                    .eq(ProductCommentPO::getProductId, req.getProductSpuId());
        }
        Page<ProductCommentPO> commentPOPage = productCommentDAO.selectPage(page, eq);
        return PageUtil.convert(commentPOPage, CommentRes.class);
    }
}
