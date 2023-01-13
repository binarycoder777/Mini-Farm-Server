package com.cqut.atao.farm.user.domain.strategy.policy;

import cn.hutool.json.JSONObject;
import com.cqut.atao.farm.user.domain.converter.UserConverter;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.vo.VxUserLoginVO;
import com.cqut.atao.farm.user.domain.properites.WechatAuthProperites;
import com.cqut.atao.farm.user.domain.repository.IUserRepository;
import com.cqut.atao.farm.user.domain.strategy.LoginStrategy;
import com.cqut.atao.farm.user.domain.util.VxUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName VxLoginStrategy.java
 * @Description 微信登录策略
 * @createTime 2023年01月13日 16:51:00
 */
@Component
public class VxLoginStrategy implements LoginStrategy{

    @Resource
    private IUserRepository userRepository;

    @Resource
    private WechatAuthProperites wechatAuthProperites;

    @Override
    public LoginRes login(Map<String, String> data) {
        // 1.开发者服务器 登录凭证校验接口 appId + appSecret + 接收小程序发送的code
        JSONObject SessionKeyOpenId = VxUtil.getSessionKeyOrOpenId(data.get("code"),wechatAuthProperites.getSessionHost(),wechatAuthProperites.getAppId(),wechatAuthProperites.getSecret(),wechatAuthProperites.getGrantType());
        // 2.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.get("openid", String.class);
        String sessionKey = SessionKeyOpenId.get("session_key", String.class);
        // 3.自定义登录态(与openid、session_key关联)
        String token = VxUtil.generateAccessToken(openid,sessionKey);
        // 4.转化用户基础信息
        VxUserLoginVO vxUserLoginVO = UserConverter.conver(data);
        // 5.检测是否首次登录(存储用户信息)
        LoginRes loginRes = userRepository.checkUserInfo(vxUserLoginVO);
        loginRes.setAccessToken(token);
        // 6.返回响应结果
        return loginRes;
    }
}


