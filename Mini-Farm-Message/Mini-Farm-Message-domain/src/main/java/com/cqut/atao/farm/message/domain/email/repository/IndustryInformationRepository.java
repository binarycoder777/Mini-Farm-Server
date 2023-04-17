package com.cqut.atao.farm.message.domain.email.repository;

import com.cqut.atao.farm.message.domain.email.model.req.AddIndustryInformationReq;
import com.cqut.atao.farm.message.domain.email.model.req.InformationListReq;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IndustryInformationRepository.java
 * @Description 行业资讯仓储层
 * @createTime 2023年04月17日 09:36:00
 */
public interface IndustryInformationRepository {

    PageResponse<IndustryInformationRes> queryIndustryInformation(InformationListReq req);

    void insertIndustryInformation(AddIndustryInformationReq req);
}
