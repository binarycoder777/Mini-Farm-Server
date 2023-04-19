package com.cqut.atao.farm.coupon.domain.activity.kill.model.req;

import com.cqut.atao.farm.coupon.domain.remote.model.req.PlaceOrderReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName KillOrderReq.java
 * @Description 订单描述
 * @createTime 2023年04月16日 11:22:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KillOrderReq {

    private Long id;

    private PlaceOrderReq req;

}
