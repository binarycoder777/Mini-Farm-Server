package com.cqut.atao.farm.coupon.domain.coupon.model.aggreate;

import com.cqut.atao.farm.coupon.domain.coupon.model.vo.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponListReq.java
 * @Description 获取优惠券列表
 * @createTime 2023年04月18日 10:12:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponListReq {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 商品列表
     */
    private List<OrderProduct> orderProducts;

}
