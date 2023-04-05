package com.cqut.atao.farm.pay.application.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayResultReq.java
 * @Description 支付结果回调请求
 * @createTime 2023年04月05日 16:57:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayResultReq {

    private Long userId;

    private String orderSn;

    private Integer payCode;

}
