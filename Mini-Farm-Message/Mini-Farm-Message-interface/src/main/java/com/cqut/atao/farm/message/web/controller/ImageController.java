package com.cqut.atao.farm.message.web.controller;

import com.cqut.atao.farm.message.application.common.service.ImageService;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ImageController.java
 * @Description 图片管理
 * @createTime 2023年04月25日 17:12:00
 */
@Api(tags = "图片管理")
@RestController
@RequestMapping("/api/message/image")
public class ImageController  {

    @Resource
    private ImageService imageService;

    @ApiOperation("图片上传")
    @PostMapping("/upload/")
    public Result<String> upload(@RequestParam("pic") MultipartFile multipartFile) throws IOException {
        String path = imageService.uploadPictureAly(multipartFile);
        return Results.success(path);
    }

}
