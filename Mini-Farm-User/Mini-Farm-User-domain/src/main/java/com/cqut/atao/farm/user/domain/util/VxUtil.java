package com.cqut.atao.farm.user.domain.util;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Maps;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class VxUtil {

    private static final long EXPIRATION = 86400L;

    public static final String ISS = "Mini-Farm";

    public static final String SECRET = "6a2aa19aa027ebe1e9d8a0bcc340ae38";


    /**
     * 生成用户 Token
     * @param userId 用户id
     * @return token
     */
    public static String generateAccessToken(Long userId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("userId", userId);
        return Jwts
                .builder()
                // 信息头
                .setHeaderParam("typ","JWT")
                // 主题信息
                .setSubject(JSON.toJSONString(map))
                // 签名
                .signWith(SignatureAlgorithm.HS512, SECRET)
                // 创建时间
                .setIssuedAt(new Date())
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .setIssuer(ISS)
                .compact();
    }


    /**
     * 验证token
     * @return  token正确返回对象，token不正确返回null
     */
    public static Claims getClaimByToken(String token){
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET)  //获取秘钥
                    .parseClaimsJws(token)	//解析验证token
                    .getBody();
        }catch (Exception e){
            log.info("token验证失败",e);
            return  null;
        }
    }

    /**
     * token是否过期
     * @return  true：过期
     * lastLoginDate 数据库记录的最后一次登出时间
     * issueDate token 创建时间
     */
    public boolean isTokenExpired(Claims claims,Date lastLoginDate) {
        //token创建时间小于数据库记录的最后一次登出时间 过期
        if(lastLoginDate == null){
            return claims.getExpiration().before(new Date());
        }else{
            return claims.getIssuedAt().before(lastLoginDate);
        }
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

