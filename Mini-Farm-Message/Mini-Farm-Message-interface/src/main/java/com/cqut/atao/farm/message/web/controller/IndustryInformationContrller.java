package com.cqut.atao.farm.message.web.controller;

import com.cqut.atao.farm.message.application.service.IndustryInformationRepositoryMange;
import com.cqut.atao.farm.message.domain.email.model.req.*;
import com.cqut.atao.farm.message.domain.email.model.res.CommentRes;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationDetail;
import com.cqut.atao.farm.message.domain.email.model.res.IndustryInformationRes;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IndustryInformationContrller.java
 * @Description 行业资讯控制
 * @createTime 2023年04月17日 09:35:00
 */
@RestController
@Slf4j
@Api(tags = "行业资讯")
@RequestMapping("/api/industry")
public class IndustryInformationContrller {

    @Resource
    private IndustryInformationRepositoryMange industryInformationRepositoryMange;


    @ApiOperation("发布资讯")
    @PostMapping(value = "/information/add")
    public Result<Void> addIndustryInformation(@RequestBody AddIndustryInformationReq req) throws Exception {
        industryInformationRepositoryMange.addIndustryInformation(req);
        return Results.success();
    }

    @ApiOperation("资讯列表")
    @GetMapping(value = "/information/list")
    public Result<PageResponse<IndustryInformationRes>> getIndustryInformation(InformationListReq req) throws Exception {
        PageResponse<IndustryInformationRes> list = industryInformationRepositoryMange.getIndustryInformation(req);
        return Results.success(list);
    }

    @ApiOperation("资讯详情")
    @GetMapping(value = "/information/{id}")
    public Result<IndustryInformationDetail> getIndustryInformation(@PathVariable("id")Long id) throws Exception {
        IndustryInformationDetail detail = industryInformationRepositoryMange.getIndustryInformation(id);
        return Results.success(detail);
    }


    @ApiOperation("点击资讯")
    @PutMapping(value = "/click")
    public Result<Void> clickIndustryInformation(ClickReq req) throws Exception {
        industryInformationRepositoryMange.click(req);
        return Results.success();
    }

    @ApiOperation("评论资讯")
    @PutMapping(value = "/comment")
    public Result<Void> commentIndustryInformation(CommentReq req) throws Exception {
        industryInformationRepositoryMange.comment(req);
        return Results.success();
    }

    @ApiOperation("资讯评论列表")
    @GetMapping(value = "/comment/list/{id}")
    public Result<PageResponse<CommentRes>> industryInformationCommentList(PageCommentReq req) throws Exception {
        PageResponse<CommentRes> res = industryInformationRepositoryMange.commentList(req);
        return Results.success(res);
    }


}
