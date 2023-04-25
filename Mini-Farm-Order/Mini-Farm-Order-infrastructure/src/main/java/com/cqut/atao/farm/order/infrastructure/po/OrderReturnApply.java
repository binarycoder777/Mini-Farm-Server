package com.cqut.atao.farm.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.order.domain.refund.model.req.ReturnOrderApplyReq;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderReturnApply.java
 * @Description 订单退货申请
 * @createTime 2023年04月23日 13:57:00
 */
@Data
@Builder
@TableName("order_return_apply")
public class OrderReturnApply {

    /**
     * id
     */
    private Long id;

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
    private Long userId;

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

    public static OrderReturnApply generate(ReturnOrderApplyReq returnOrderApplyReq){
        return OrderReturnApply.builder()
                .status(returnOrderApplyReq.getStatus())
                .applyTime(returnOrderApplyReq.getApplyTime())
                .descPics(returnOrderApplyReq.getDescPics())
                .reason(returnOrderApplyReq.getReason())
                .orderSn(returnOrderApplyReq.getOrderSn())
                .returnAmount(returnOrderApplyReq.getReturnAmount())
                .userId(returnOrderApplyReq.getUserId())
                .build();
    }

}
