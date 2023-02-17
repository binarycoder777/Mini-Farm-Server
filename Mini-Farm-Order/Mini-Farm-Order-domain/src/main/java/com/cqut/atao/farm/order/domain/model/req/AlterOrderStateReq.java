package com.cqut.atao.farm.order.domain.model.req;

import com.cqut.atao.farm.order.domain.service.stateflow.Constants;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AlterOrderStateReq.java
 * @Description 订单状态流转请求
 * @createTime 2023年02月17日 15:29:00
 */
@Data
public class AlterOrderStateReq {

    // 订单号
    private Long orderId;

    // 订单当前状态
    private Enum<Constants.OrderState> currentSate;

}
