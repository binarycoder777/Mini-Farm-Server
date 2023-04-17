package com.cqut.atao.farm.message.application.service.impI;

import com.cqut.atao.farm.message.application.service.IndustryInformationRepositoryMange;
import com.cqut.atao.farm.message.domain.email.model.req.AddIndustryInformationReq;
import com.cqut.atao.farm.message.domain.email.model.req.InformationListReq;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationRes;
import com.cqut.atao.farm.message.domain.email.repository.IndustryInformationRepository;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IndustryInformationRepositoryMangeImpI.java
 * @Description 资讯管理
 * @createTime 2023年04月17日 09:38:00
 */
@Service
public class IndustryInformationRepositoryMangeImpI implements IndustryInformationRepositoryMange {

    @Resource
    private IndustryInformationRepository industryInformationRepository;

    @Override
    public PageResponse<IndustryInformationRes> getIndustryInformation(InformationListReq req) {
        return industryInformationRepository.queryIndustryInformation(req);
    }

    @Override
    public void addIndustryInformation(AddIndustryInformationReq req) {
        industryInformationRepository.insertIndustryInformation(req);
    }
}
