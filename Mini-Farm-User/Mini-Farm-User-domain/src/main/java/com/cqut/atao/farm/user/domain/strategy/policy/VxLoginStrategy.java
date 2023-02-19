package com.cqut.atao.farm.user.domain.strategy.policy;

import cn.hutool.json.JSONObject;
import com.cqut.atao.farm.user.domain.model.req.BaseLoginReq;
import com.cqut.atao.farm.user.domain.model.req.VxUserLoginReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.properites.WechatAuthProperites;
import com.cqut.atao.farm.user.domain.repository.UserRepository;
import com.cqut.atao.farm.user.domain.strategy.LoginStrategy;
import com.cqut.atao.farm.user.domain.util.VxUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName VxLoginStrategy.java
 * @Description 微信登录策略
 * @createTime 2023年01月13日 16:51:00
 */
@Slf4j
@Component
public class VxLoginStrategy implements LoginStrategy{

    @Resource
    private UserRepository userRepository;

    @Resource
    private WechatAuthProperites wechatAuthProperites;

    @Override
    public LoginRes login(BaseLoginReq req) {
        VxUserLoginReq vxUserLoginReq = (VxUserLoginReq) req;
        // 开发者服务器 登录凭证校验接口 appId + appSecret + 接收小程序发送的code
        JSONObject SessionKeyOpenId = VxUtil.getSessionKeyOrOpenId(vxUserLoginReq.getCode(),wechatAuthProperites.getSessionHost(),wechatAuthProperites.getAppId(),wechatAuthProperites.getSecret(),wechatAuthProperites.getGrantType());
        // 接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.get("openid", String.class);
        // 检测是否首次登录（是否存在该微信号信息）
        boolean exeits = userRepository.checkUserInfoByOpenId(openid);
        // 不存在，则自动将该微信号注册为新用户
        if (!exeits) {
            vxUserLoginReq.setOpenid(openid);
            userRepository.addUser(vxUserLoginReq);
        }
        // 获取用户登录返回信息
        LoginRes loginRes = userRepository.getUserInfoByOpenId(openid);
        // 自定义登录态
        String token = VxUtil.generateAccessToken(loginRes.getId());
        loginRes.setAccessToken(token);
        // 返回响应结果
        return loginRes;
    }
}


