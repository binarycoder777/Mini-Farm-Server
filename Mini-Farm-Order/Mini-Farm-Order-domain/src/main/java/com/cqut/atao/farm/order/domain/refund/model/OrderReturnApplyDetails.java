package com.cqut.atao.farm.order.domain.refund.model;

import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderReturnApply.java
 * @Description 订单退货申请
 * @createTime 2023年04月23日 13:57:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderReturnApplyDetails {

    /**
     * id
     */
    private String id;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 退款金额
     */
    private BigDecimal returnAmount;

    /**
     * 确认退款金额
     */
    private BigDecimal confirmReturnAmount;

    /**
     * 退款状态
     */
    private Integer status;

    /**
     * 退款原因
     */
    private String reason;

    /**
     * 图片描述
     */
    private String descPics;

    /**
     * 运单号（有则填）
     */
    private String deliverySn;

    /**
     * 退货仓库地址
     */
    private Integer wareAddressId;

    /**
     * 订单对应商品
     */
    private List<OrderProduct> orderProductList;

}
