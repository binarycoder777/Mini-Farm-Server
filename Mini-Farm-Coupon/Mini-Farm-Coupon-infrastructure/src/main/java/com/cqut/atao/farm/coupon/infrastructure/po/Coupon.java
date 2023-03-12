package com.cqut.atao.farm.coupon.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@TableName("coupon")
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
}
