package com.cqut.atao.farm.user.domain.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Maps;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WxUtil.java
 * @Description 微信认证工具类
 * @createTime 2023年01月13日 19:37:00
 */
public class VxUtil {

    private static final long EXPIRATION = 86400L;

    public static final String ISS = "Mini-Farm";

    public static final String SECRET = "SecretKey039245678901232039487623456783092349288901402967890140939827";


    /**
     * 生成用户 Token
     * @param openid vx开放id
     * @param sessionKey sessionKey
     * @return token
     */
    public static String generateAccessToken(String openid, String sessionKey) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("openid", openid);
        map.put("sessionKey", sessionKey);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuedAt(new Date())
                .setIssuer(ISS)
                .setSubject(JSON.toJSONString(map))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();
    }

    /**
     * 根据前端的code和配置类的信息，得到openid和sessionkey
     * @param code
     * @param url
     * @param appid
     * @param secret
     * @param grant_type
     * @return
     */
    public static JSONObject getSessionKeyOrOpenId(String code, String url, String appid, String secret, String grant_type) {
        String requestUrl = url;
        HashMap<String, Object> requestUrlParam = new HashMap<>();
        //小程序appId
        requestUrlParam.put("appid", appid);
        //小程序secret
        requestUrlParam.put("secret", secret);
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数
        requestUrlParam.put("grant_type", grant_type);
        //发送post请求读取调用微信接口获取openid用户唯一标识
        String result = HttpUtil.get(requestUrl, requestUrlParam);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        return jsonObject;
    }

}

