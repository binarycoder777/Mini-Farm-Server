package com.cqut.atao.farm.order.domain.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PendingTransactions.java
 * @Description 待处理事务数
 * @createTime 2023年05月01日 22:16:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PendingTransactions {

    /**
     * 待付款
     */
    private Integer waitPay;

    /**
     * 待确认收货
     */
    private Integer waitConfirmRecive;

    /**
     * 待发货
     */
    private Integer waitSendProduct;
    /**
     * 待退货
     */
    private Integer waitReturnProduct;
    /**
     * 待退款
     */
    private Integer waitRefundMoney;
    /**
     * 已发货
     */
    private Integer sendProduct;

}
