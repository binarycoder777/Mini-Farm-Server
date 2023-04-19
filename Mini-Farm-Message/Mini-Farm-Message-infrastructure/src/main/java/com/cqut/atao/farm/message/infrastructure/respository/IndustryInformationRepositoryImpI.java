package com.cqut.atao.farm.message.infrastructure.respository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.message.domain.email.model.req.*;
import com.cqut.atao.farm.message.domain.email.model.res.CommentRes;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationDetail;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationRes;
import com.cqut.atao.farm.message.domain.email.repository.IndustryInformationRepository;
import com.cqut.atao.farm.message.infrastructure.dao.CommentDAO;
import com.cqut.atao.farm.message.infrastructure.dao.IndustryInformationDAO;
import com.cqut.atao.farm.message.infrastructure.po.Comment;
import com.cqut.atao.farm.message.infrastructure.po.IndustryInformation;
import com.cqut.atao.farm.message.infrastructure.util.RedisUtil;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IndustryInformationRepositoryImpI.java
 * @Description 行业资讯
 * @createTime 2023年04月17日 09:37:00
 */
@Repository
public class IndustryInformationRepositoryImpI implements IndustryInformationRepository {

    @Resource
    private IndustryInformationDAO industryInformationDAO;

    @Resource
    private CommentDAO commentDAO;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public PageResponse<IndustryInformationRes> queryIndustryInformation(InformationListReq req) {
        Page<IndustryInformation> page = new Page<>(req.getCurrent(),req.getSize());
        // 根据时间降序
        Page<IndustryInformation> selectPage = industryInformationDAO.selectPage(page, Wrappers.lambdaQuery(IndustryInformation.class)
                .orderByDesc(IndustryInformation::getId));
        return PageUtil.convert(selectPage,IndustryInformationRes.class);
    }

    @Override
    public void insertIndustryInformation(AddIndustryInformationReq req) {
        industryInformationDAO.insert(BeanUtil.convert(req,IndustryInformation.class));
    }

    @Override
    public IndustryInformationDetail queryIndustryInformationDetail(Long id) {
        IndustryInformation industryInformation = industryInformationDAO.selectById(id);
        return BeanUtil.convert(industryInformation,IndustryInformationDetail.class);
    }

    @Override
    public void click(ClickReq req) {
        redisUtil.incr("INDUSTRY_INFORMATION_CLICK:"+req.getTargetId(),1);
    }

    @Override
    public void comment(CommentReq req) {
        commentDAO.insert(BeanUtil.convert(req, Comment.class));
    }

    @Override
    public PageResponse<CommentRes> queryCommentList(PageCommentReq req) {

        return null;
    }
}
