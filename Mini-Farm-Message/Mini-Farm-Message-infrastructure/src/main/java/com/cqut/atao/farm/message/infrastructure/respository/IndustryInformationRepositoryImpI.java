package com.cqut.atao.farm.message.infrastructure.respository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.message.domain.email.model.req.AddIndustryInformationReq;
import com.cqut.atao.farm.message.domain.email.model.req.InformationListReq;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationRes;
import com.cqut.atao.farm.message.domain.email.repository.IndustryInformationRepository;
import com.cqut.atao.farm.message.infrastructure.dao.IndustryInformationDAO;
import com.cqut.atao.farm.message.infrastructure.po.IndustryInformation;
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
}
