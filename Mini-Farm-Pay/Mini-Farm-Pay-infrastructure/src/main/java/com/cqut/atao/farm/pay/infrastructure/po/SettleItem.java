package com.cqut.atao.farm.pay.infrastructure.po;

import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SettleInfo.java
 * @Description 结算明细
 * @createTime 2023年03月03日 11:35:00
 */
@Data
@Builder
public class SettleItem extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 结算流水编号
     */
    private String settleSn;

    /**
     * 规则id
     */
    private Long ruleId;

    /**
     * 支出方
     */
    private Long userId;

    /**
     * 收入方
     */
    private Long merchantId;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 类型（收入、支出）
     */
    private Integer payType;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 实际收支金额
     */
    private BigDecimal payAmount;

}
