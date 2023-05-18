package com.cqut.atao.farm.order.domain.operate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OperateRes.java
 * @Description 操作结果
 * @createTime 2023年04月24日 14:39:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateRes {


    /**
     * id
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 操作人
     */
    private String operateMan;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 事件类型
     */
    private Integer eventType;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 备注
     */
    private String note;

}
