package com.cqut.atao.farm.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderPO.java
 * @Description 订单持久化类
 * @createTime 2023年02月04日 15:01:00
 */
@Data
@TableName("order_info")
public class OrderPO extends BaseDO {
    /**
     * id
     */
    private String id;

    /**
     * 父订单ID
     */
    private String parentId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    private BigDecimal freightAmount;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 订单来源
     */
    private Integer source;

    /**
     * 订单类型 0：正常订单 1：秒杀订单 2：促销订单
     */
    private Integer type;

    /**
     * 自动确认天数
     */
    private Integer autoConfirmDay;

    /**
     * 物流公司
     */
    private String deliveryCompany;

    /**
     * 物流单号
     */
    private String deliverySn;

    /**
     * 收货人
     */
    private String cneeName;

    /**
     * 收货人电话
     */
    private String cneePhone;

    /**
     * 收货人邮编
     */
    private String cneePostCode;

    /**
     * 收货人所在省
     */
    private String cneeProvinc;

    /**
     * 收货人所在市
     */
    private String cneeCity;

    /**
     * 收货人所在区
     */
    private String cneeRegion;

    /**
     * 收货人详细地址
     */
    private String cneeDetailAddress;

    /**
     * 收货时间
     */
    private Date receiveTime;

    /**
     * 订单备注信息
     */
    private String remark;

    /**
     * 收货状态 0：未接收 1：已接收
     */
    private Integer confirmFlag;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 订单商品详情
     */
    @TableField(exist = false)
    private List<OrderItemPO> orderProducts;

    /**
     * 优惠券编码
     */
    private Long couponSn;

    /**
     * 优惠券抵扣金额 | 分摊优惠
     */
    private BigDecimal couponAmount;

    /**
     * 促销活动编码
     */
    private Long promotionSn;
    /**
     * 促销金额 | 分摊优惠
     */
    private BigDecimal promotionAmount;

    /**
     * 使用积分
     */
    private Integer useIntegration;

    /**
     * 积分抵扣金额
     */
    private BigDecimal integrationAmount;

}
