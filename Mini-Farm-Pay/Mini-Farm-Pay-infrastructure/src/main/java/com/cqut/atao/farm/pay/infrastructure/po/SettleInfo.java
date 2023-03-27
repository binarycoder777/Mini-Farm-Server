package com.cqut.atao.farm.pay.infrastructure.po;

import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SettleInfo.java
 * @Description 结算单信息
 * @createTime 2023年03月03日 11:35:00
 */
@Data
@Builder
public class SettleInfo extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 结算流水编号
     */
    private String settleSn;

    /**
     * 总支出
     */
    private BigDecimal totalPay;

    /**
     * 总收入
     */
    private BigDecimal totalIncome;

    /**
     * 合计
     */
    private BigDecimal totalAmount;

    /**
     * 是否结算打款
     */
    private byte settle;

    /**
     * 收支明细
     */
    private List<SettleItem> itemList;

}
