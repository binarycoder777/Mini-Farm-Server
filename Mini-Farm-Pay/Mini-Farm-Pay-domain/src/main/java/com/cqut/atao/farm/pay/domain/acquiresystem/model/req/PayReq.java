package com.cqut.atao.farm.pay.domain.acquiresystem.model.req;

import com.cqut.atao.farm.pay.domain.thirdpayment.Constants;
import com.cqut.atao.farm.pay.domain.thirdpayment.model.aggreate.Order;
import lombok.Builder;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayReq.java
 * @Description 支付请求
 * @createTime 2023年02月23日 20:15:00
 */
@Data
@Builder
public class PayReq {

    /**
     * 支付类型
     */
    private Integer payCode;

    /**
     * 支付单
     */
    private Order order;

}
