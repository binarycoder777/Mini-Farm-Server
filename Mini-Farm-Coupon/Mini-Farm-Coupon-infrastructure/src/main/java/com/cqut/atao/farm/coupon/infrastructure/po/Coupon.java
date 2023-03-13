package com.cqut.atao.farm.coupon.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.*;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Coupon.java
 * @Description 优惠券po类
 * @createTime 2023年03月12日 15:55:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("coupon_info")
public class Coupon extends BaseDO {

    /**
     * id
     */
    private Long id;
    /**
     * 优惠券名字
     */
    private String couponName;
    /**
     * 优惠券面额
     */
    private Long couponValue;
    /**
     * 优惠券数量
     */
    private Long couponNum;
    /**
     * 发放时间
     */
    private Date distributeTime;
    /**
     * 有效期限
     */
    private Date validityTime;
    /**
     * 是否可叠加
     */
    private Integer isSuperposition;
    /**
     * 优惠券类型
     */
    private Integer couponType;
    /**
     * 优惠券使用范围（0：全平台 1：指定商品(redis存储) 2：指定类型(redis存储)））
     */
    private Integer couponScope;
    /**
     * 优惠券分发类型（0：系统发放 1：人工发放 2：用户领取）
     */
    private Integer distributeType;
    /**
     * 优惠券分发规则（0：无规则 1：有规则）
     */
    private Integer distributeRule;
    /**
     * 优惠券分发对象（0：所有对象 1：筛选对象）
     */
    private Integer distributeObject;
}
