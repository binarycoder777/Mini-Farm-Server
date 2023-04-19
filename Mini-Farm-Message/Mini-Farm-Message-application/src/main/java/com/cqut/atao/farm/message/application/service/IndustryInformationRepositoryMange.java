package com.cqut.atao.farm.message.application.service;

import com.cqut.atao.farm.message.domain.email.model.req.AddIndustryInformationReq;
import com.cqut.atao.farm.message.domain.email.model.req.ClickReq;
import com.cqut.atao.farm.message.domain.email.model.req.CommentReq;
import com.cqut.atao.farm.message.domain.email.model.req.InformationListReq;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationDetail;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IndustryInformationRepositoryMange.java
 * @Description 资讯管理
 * @createTime 2023年04月17日 09:38:00
 */
public interface IndustryInformationRepositoryMange {
    PageResponse<IndustryInformationRes> getIndustryInformation(InformationListReq req);

    IndustryInformationDetail getIndustryInformation(Long id);

    void addIndustryInformation(AddIndustryInformationReq req);

    void click(ClickReq req);

    void comment(CommentReq req);
}
