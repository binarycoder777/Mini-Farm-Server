package com.cqut.atao.farm.message.application.common.service;

import com.cqut.atao.farm.message.application.common.properties.OSSProperties;
import com.cqut.atao.farm.message.application.common.util.OssUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ImageService.java
 * @Description 图片服务
 * @createTime 2023年04月25日 17:15:00
 */
@Slf4j
@Service
public class ImageService {

    @Resource
    private OSSProperties ossProperties;

    /**
     * 上传图片到阿里云
     * @param file
     * @return
     */
    public String uploadPictureAly(MultipartFile file) throws IOException {
        String path = "";
        log.warn("{}",file.getInputStream());
        log.warn("{}",ossProperties.getBucketName());
        try {
            path = OssUtils.uploadFileToOss(ossProperties.getEndPoint(),ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret(),file.getInputStream(),ossProperties.getBucketName(),ossProperties.getBucketDomain(),file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
