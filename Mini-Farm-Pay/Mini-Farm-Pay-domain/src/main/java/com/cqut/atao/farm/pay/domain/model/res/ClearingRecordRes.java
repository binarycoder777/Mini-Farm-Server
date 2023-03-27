package com.cqut.atao.farm.pay.domain.model.res;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ClearingRecord.java
 * @Description 清分记录
 * @createTime 2023年03月02日 14:11:00
 */
@Data
@Builder
public class ClearingRecordRes{

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商家id
     */
    private Long merchantId;

    /**
     * 清分对象
     */
    private Long clearUserId;

    /**
     * 计费规则id
     */
    private Long ruleId;

    /**
     * 清分流水号
     */
    private String clearSn;

    /**
     * 记录来源
     */
    private Integer source;

    /**
     * 清分类型
     */
    private Integer clearType;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 结算状态
     */
    private Integer settleStatus;

    public static String generateClearingSn() {
        return UUID.randomUUID().toString();
    }

}
