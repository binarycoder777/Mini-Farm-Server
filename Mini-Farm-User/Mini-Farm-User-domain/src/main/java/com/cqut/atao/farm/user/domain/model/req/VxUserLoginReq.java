package com.cqut.atao.farm.user.domain.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName VxLoginVO.java
 * @Description 微信用户LoginReq类
 * @createTime 2023年01月13日 20:28:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VxUserLoginReq extends BaseLoginReq{
    @ApiModelProperty(value = "微信openid")
    private String openid;
    @ApiModelProperty(value = "code码")
    private String code;
    @ApiModelProperty(value = "昵称")
    private String username;
    @ApiModelProperty(value = "头像")
    private String avater;
}
