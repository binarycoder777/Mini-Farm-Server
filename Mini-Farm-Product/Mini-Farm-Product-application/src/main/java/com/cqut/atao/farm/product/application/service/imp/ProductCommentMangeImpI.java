package com.cqut.atao.farm.product.application.service.imp;

import com.cqut.atao.farm.product.application.service.ProductCommentMange;
import com.cqut.atao.farm.product.domain.mode.req.CommentProductReq;
import com.cqut.atao.farm.product.domain.mode.req.PageCommentReq;
import com.cqut.atao.farm.product.domain.mode.res.CommentRes;
import com.cqut.atao.farm.product.domain.mode.res.CommentStatisticsRes;
import com.cqut.atao.farm.product.domain.mq.produce.ProductProduce;
import com.cqut.atao.farm.product.domain.remote.RemoteOrderService;
import com.cqut.atao.farm.product.domain.repository.ProductCommentRepository;
import com.cqut.atao.farm.rocketmq.springboot.starter.event.CommentOrderMessageSendEvent;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCommentMangeImpI.java
 * @Description 商品评论管理实现类
 * @createTime 2023年04月08日 13:57:00
 */
@Service
public class ProductCommentMangeImpI implements ProductCommentMange {

    @Resource
    private RemoteOrderService remoteOrderService;

    @Resource
    private ProductCommentRepository productCommentRepository;


    @Override
    public void doComment(CommentProductReq req) {
        // 添加评论
        req.getComments().stream().forEach(e->{
            e.convertToStr();
            productCommentRepository.addComment(e);
        });
        // 扭转订单状态
        remoteOrderService.alterOrderStatusToComment(req.getOrderSn());
    }


    @Override
    public List<CommentStatisticsRes> categoryStatisticsComment(Long productSpuId) {
        // 评论统计
        List<CommentStatisticsRes> list = Lists.newArrayList();
        // 全部
        CommentStatisticsRes all = productCommentRepository.queryAllCommentStatistics(productSpuId);
        list.add(all);
        // 好评
        CommentStatisticsRes good = productCommentRepository.queryGoodCommentStatistics(productSpuId);
        list.add(good);
        // 中评
        CommentStatisticsRes secondary = productCommentRepository.querySecondaryCommentStatistics(productSpuId);
        list.add(secondary);
        // 差评
        CommentStatisticsRes poor = productCommentRepository.queryPoorCommentStatistics(productSpuId);
        list.add(poor);
        // 带图
        CommentStatisticsRes img = productCommentRepository.queryImgCommentStatistics(productSpuId);
        list.add(img);
        // 视频
        CommentStatisticsRes video = productCommentRepository.queryVideoCommentStatistics(productSpuId);
        list.add(video);
        // 追加
        CommentStatisticsRes append = productCommentRepository.queryAppendCommentStatistics(productSpuId);
        list.add(append);
        return list;
    }

    @Override
    public PageResponse<CommentRes> pageQueryComment(PageCommentReq req) {
        PageResponse<CommentRes> response = productCommentRepository.pageQueryComment(req);
        // 填充信息
        response.getRecords().forEach(e->{
            // 调用用户服务获取用户名和头像
        });
        return response;
    }
}
