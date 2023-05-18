package com.cqut.atao.farm.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderOperateRecord.java
 * @Description 订单操作记录
 * @createTime 2023年04月24日 14:25:00
 */
@Data
@TableName("order_operate_history")
public class OrderOperateRecord {

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
