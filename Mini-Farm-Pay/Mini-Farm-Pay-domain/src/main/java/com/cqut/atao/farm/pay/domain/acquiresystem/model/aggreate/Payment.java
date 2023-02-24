package com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Payment.java
 * @Description 支付单
 * @createTime 2023年02月23日 20:22:00
 */
@Data
@Builder
public class Payment {

    // id
    private Long id;
    // 支付流水编号
    private String paySn;
    // 订单流水编号
    private String orderSn;
    // 用户id
    private Long userId;
    // 用户名
    private String userName;
    // 总金额
    private BigDecimal totalAmount;
    // 实际支付金额
    private BigDecimal payAmount;
    // 运费
    private BigDecimal freightAmount;
    // 支付方式
    private Integer payType;
    // 支付时间
    private Date payTime;
    // 支付状态（0：付款、1：退款、2：打款）
    private Integer status;

}
