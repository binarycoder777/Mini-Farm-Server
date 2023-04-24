package com.cqut.atao.farm.order.domain.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AlterAddressReq.java
 * @Description 修改订单上的用户地址
 * @createTime 2023年04月23日 11:01:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlterAddressReq {

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 收货人
     */
    private String cneeName;

    /**
     * 收货人电话
     */
    private String cneePhone;


    /**
     * 收货人所在区
     */
    private String cneeRegion;

    /**
     * 收货人详细地址
     */
    private String cneeDetailAddress;

}
