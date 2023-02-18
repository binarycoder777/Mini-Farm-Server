package com.cqut.atao.farm.order.domain.remote.model.res;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CheckAmountRes.java
 * @Description 核验金额结果
 * @createTime 2023年02月18日 10:47:00
 */
@Data
@Builder
public class CheckAmountRes {

    private BigDecimal payAmount;

}
