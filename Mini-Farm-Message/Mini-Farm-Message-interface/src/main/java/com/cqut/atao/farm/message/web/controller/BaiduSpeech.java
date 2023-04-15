package com.cqut.atao.farm.message.web.controller;


import com.baidu.aip.speech.AipSpeech;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;


/**
 * @author atao
 * @version 1.0.0
 * @ClassName BaiduSpeech.java
 * @Description 语音解析
 * @createTime 2023年04月14日 21:28:00
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
@Api(tags = "语音转文字")
@RequestMapping("/yuyin")
public class BaiduSpeech {

    @Value("${baidu.yuyin.app.id}")
    public String APP_ID;
    @Value("${baidu.yuyin.api.key}")
    public String API_KEY;
    @Value("${baidu.yuyin.secret.key}")
    public String SECRET_KEY;

    @ApiOperation("上传语音")
    @RequestMapping(value = "/uploadFile")
    public String uploadFile(@RequestParam("dev_id") int dev_id, @RequestParam("file") MultipartFile file) throws Exception {
        // 对语音二进制数据进行识别
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        JSONObject asrRes2 = client.asr(file.getBytes(), "m4a", 16000, null);
        return asrRes2.toString();
    }

}
