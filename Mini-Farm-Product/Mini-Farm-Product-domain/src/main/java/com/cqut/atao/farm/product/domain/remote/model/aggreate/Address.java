package com.cqut.atao.farm.product.domain.remote.model.aggreate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Address.java
 * @Description 用户收货信息集合类
 * @createTime 2023年02月04日 15:56:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    /**
     * 收货人
     */
    private String cneeName;

    /**
     * 收货人电话
     */
    private String cneePhone;

    /**
     * 收货人邮编
     */
    private String cneePostCode;

    /**
     * 收货人所在省
     */
    private String cneeProvinc;

    /**
     * 收货人所在市
     */
    private String cneeCity;

    /**
     * 收货人所在区
     */
    private String cneeRegion;

    /**
     * 收货人详细地址
     */
    private String cneeDetailAddress;

    /**
     * 收货时间
     */
    private Date receiveTime;
}

