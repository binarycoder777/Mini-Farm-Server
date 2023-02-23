package com.cqut.atao.farm.pay.domain.remote;

import com.cqut.atao.farm.pay.domain.remote.model.res.UserInfoRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteMessageSerivce.java
 * @Description 远程消息服务
 * @createTime 2023年02月23日 15:37:00
 */
@FeignClient
public interface RemoteUserSerivce {

    @GetMapping("/api/user/getInfo/{userId}")
    Result<UserInfoRes> getUserInfoByUserId(@PathVariable Long userId);

}
