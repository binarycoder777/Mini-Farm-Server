package com.cqut.atao.farm.user.domain.model.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName LoginRes.java
 * @Description 登录返回结果
 * @createTime 2023年01月13日 18:08:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRes {

    @ApiModelProperty(value = "用户ID")
    private Long customerUserId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "账号")
    private String accountNumber;

    @ApiModelProperty(value = "Token")
    private String accessToken;
}
