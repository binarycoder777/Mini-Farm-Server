package com.cqut.atao.farm.order.domain.remote.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderInfo.java
 * @Description 订单信息
 * @createTime 2023年02月19日 16:56:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoReq {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单商品详情
     */
    private List<OrderItemInfo> orderItemInfos;

}
