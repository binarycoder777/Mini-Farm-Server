package com.cqut.atao.farm.user.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressPO.java
 * @Description 用户收货地址
 * @createTime 2023年01月13日 20:59:00
 */
@Data
@TableName("tb_address")
public class ReceiveAddress extends BaseDO {

    /**
     * id
     */
    private String id;

    /**
     * c端用户 id
     */
    private Long userId;

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

