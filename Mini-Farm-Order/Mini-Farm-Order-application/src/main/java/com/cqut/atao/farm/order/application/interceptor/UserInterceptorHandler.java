package com.cqut.atao.farm.order.application.interceptor;

import com.cqut.atao.farm.order.domain.common.HostHolder;
import com.cqut.atao.farm.order.domain.remote.RemoteUserService;
import com.cqut.atao.farm.order.domain.remote.model.res.UserInfoRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserInterceptorHandler.java
 * @Description 用户拦截处理
 * @createTime 2023年04月25日 10:04:00
 */
@Slf4j
@Component
public class UserInterceptorHandler implements HandlerInterceptor{

    @Resource
    private HostHolder hostHolder;

    @Resource
    private RemoteUserService remoteUserService;

    /**
     * 前置处理，根据jwt获取用户信息
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String authorzation = request.getHeader("Authorization");
            UserInfoRes data = remoteUserService.getUserInfoByAuthorzation(authorzation).getData();
            hostHolder.setUser(data);
        }catch (Exception e) {
            log.info("{}",e);
        }
        return true;
    }


}
