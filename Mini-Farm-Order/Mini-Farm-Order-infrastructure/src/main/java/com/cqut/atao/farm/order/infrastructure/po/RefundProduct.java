package com.cqut.atao.farm.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RefundProduct.java
 * @Description 退货
 * @createTime 2023年04月10日 14:36:00
 */
@TableName("order_refund_product")
public class RefundProduct extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 退货原因
     */
    private String refundReason;

    /**
     * 退货图片
     */
    private String refundPic;

}
