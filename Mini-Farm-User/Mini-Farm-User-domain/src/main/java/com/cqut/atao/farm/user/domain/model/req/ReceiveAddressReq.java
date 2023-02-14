package com.cqut.atao.farm.user.domain.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressReq.java
 * @Description 收货地址请求类
 * @createTime 2023年02月14日 18:21:00
 */
@Data
public class ReceiveAddressReq {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("c端用户 id")
    private Long userId;

    @ApiModelProperty("收货人名称")
    private String name;

    @ApiModelProperty("收货人电话")
    private String phone;

    @ApiModelProperty("是否默认 0：否 1：是")
    private int defaultFlag;

    @ApiModelProperty("标签 0：家 1：公司")
    private int tag;

    @ApiModelProperty("邮政编码")
    private String postCode;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区")
    private String region;

    @ApiModelProperty("详细地址")
    private String detailAddress;
}
