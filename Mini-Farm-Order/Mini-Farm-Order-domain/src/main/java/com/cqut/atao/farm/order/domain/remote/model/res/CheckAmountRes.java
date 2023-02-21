package com.cqut.atao.farm.order.domain.remote.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class CheckAmountRes {

    private BigDecimal payAmount;

}
