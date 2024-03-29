package com.cqut.atao.farm.order.domain.remote.model.res;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponRes.java
 * @Description 优惠券结果
 * @createTime 2023年03月14日 09:20:00
 */
@Data
public class CouponRes {

    /**
     * id
     */
    private Long id;
    /**
     * 优惠券编号
     */
    private String couponSn;
    /**
     * 优惠券名字
     */
    private String couponName;
    /**
     * 优惠券面额
     */
    private Long couponValue;
    /**
     * 优惠券面额
     */
    private Long couponTick;

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
     * 优惠券可以使用范围的商品的id列表
     */
    private List<Long> productIdList;
    /**
     * 优惠券可以使用范围的商品的类别id列表
     */
    private List<Long> productTypeIdList;
    /**
     * 优惠券分发类型（0：系统发放 1：人工发放 2：用户领取）
     */
    private Integer distributeType;
    /**
     * 优惠券分发规则（0：无规则 1：有规则）
     */
    private Integer distributeRule;
    /**
     * 规则类型列表
     */
    private List<Integer> ruleType;
    /**
     * 优惠券分发对象（0：所有对象 1：筛选对象）
     */
    private Integer distributeObject;
    /**
     * 优惠券分发的筛选用户的id列表
     */
    private List<Long> userIdList;

}
