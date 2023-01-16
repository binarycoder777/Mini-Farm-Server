package com.cqut.atao.farm.user.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressPO.java
 * @Description 用户收货地址
 * @createTime 2023年01月13日 20:59:00
 */
@Data
@TableName("customer_user_receive_address")
public class ReceiveAddressPO {

    /**
     * id
     */
    private String id;

    /**
     * c端用户 id
     */
    private Long customerUserId;

    /**
     * 收货人名称
     */
    private String name;

    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 是否默认 0：否 1：是
     */
    private int defaultFlag;

    /**
     * 标签 0：家 1：公司
     */
    private int tag;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址
     */
    private String detailAddress;
}

