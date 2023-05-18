package com.cqut.atao.farm.order.domain.refund.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ConfirmReturnOrderReq.java
 * @Description 确认退单
 * @createTime 2023年04月24日 11:13:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmReturnOrderReq {

    /**
     * id
     */
    private Long id;

    /**
     * 运单号（有则填）
     */
    private String deliverySn;

    /**
     * 确认退款金额
     */
    private BigDecimal confirmReturnAmount;

    /**
     * 退货仓库地址
     */
    private Integer wareAddressId;

    /**
     * 操作人
     */
    private Integer adminId;

    /**
     * 处理备注
     */
    private String remark;

}
