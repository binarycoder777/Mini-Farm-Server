package com.cqut.atao.farm.order.domain.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderSalesVolume.java
 * @Description 订单销量
 * @createTime 2023年05月01日 19:39:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSalesVolume {

    /**
     * 日期
     */
    private Date date;

    /**
     * 订单量
     */
    private Integer orderCount;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

}
