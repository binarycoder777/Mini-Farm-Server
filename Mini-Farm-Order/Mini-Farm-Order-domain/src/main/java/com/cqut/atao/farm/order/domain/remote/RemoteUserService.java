package com.cqut.atao.farm.order.domain.remote;

import com.cqut.atao.farm.order.domain.remote.model.res.UserInfoRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteUserService.java
 * @Description 远程用户服务
 * @createTime 2023年04月04日 15:42:00
 */
@FeignClient("user")
public interface RemoteUserService {


    @GetMapping("/api/user/getInfo/{userId}")
    Result<UserInfoRes> getUserInfoByUserId(@PathVariable("userId") Long userId);

}
