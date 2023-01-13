package com.cqut.atao.farm.user.domain.properites;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WechatAuthProperites.java
 * @Description 微信认证配置
 * @createTime 2023年01月13日 19:31:00
 */
@Data
@Component
public class WechatAuthProperites {

    @Value("${auth.wechat.sessionHost}")
    private String sessionHost;

    @Value("${auth.wechat.appId}")
    private String appId;

    @Value("${auth.wechat.secret}")
    private String secret;

    @Value("${auth.wechat.grantType}")
    private String grantType;

}
