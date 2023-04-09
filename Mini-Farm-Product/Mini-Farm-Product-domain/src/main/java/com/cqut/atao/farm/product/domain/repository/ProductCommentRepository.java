package com.cqut.atao.farm.product.domain.repository;

import com.cqut.atao.farm.product.domain.mode.req.AddCommentReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCommentReq;
import com.cqut.atao.farm.product.domain.mode.res.CommentRes;
import com.cqut.atao.farm.product.domain.mode.res.CommentStatisticsRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCommentRepository.java
 * @Description 商品评论仓储接口
 * @createTime 2023年04月08日 13:58:00
 */
public interface ProductCommentRepository {
    void addComment(AddCommentReq req);

    CommentStatisticsRes queryAllCommentStatistics(Long productSpuId);

    CommentStatisticsRes queryGoodCommentStatistics(Long productSpuId);

    CommentStatisticsRes querySecondaryCommentStatistics(Long productSpuId);

    CommentStatisticsRes queryPoorCommentStatistics(Long productSpuId);

    CommentStatisticsRes queryImgCommentStatistics(Long productSpuId);

    CommentStatisticsRes queryVideoCommentStatistics(Long productSpuId);

    CommentStatisticsRes queryAppendCommentStatistics(Long productSpuId);

    PageResponse<CommentRes> pageQueryComment(PageCommentReq req);
}
