package com.cqut.atao.farm.product.domain.mode.aggregate;

import lombok.Builder;
import lombok.Data;

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
public class OrderInfo {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单商品详情
     */
    private List<OrderItemInfo> orderItemInfos;

}
