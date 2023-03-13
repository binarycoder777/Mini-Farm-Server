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
 * @ClassName TakeCoupon.java
 * @Description 领取优惠券记录类
 * @createTime 2023年03月13日 21:44:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("take_coupon")
public class TakeCoupon extends BaseDO {

    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 优惠券id
     */
    private Long couponId;
    /**
     * 领取时间
     */
    private Date takeTime;

}
