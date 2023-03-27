package com.cqut.atao.farm.coupon.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.coupon.infrastructure.po.Coupon;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponMapper.java
 * @Description 优惠卷数据访问层接口
 * @createTime 2023年03月12日 15:57:00
 */
public interface CouponMapper extends BaseMapper<Coupon> {

    /**
     * 修改优惠券状态
     * @param couponSn 优惠券编码
     * @return
     */
    @Update("update coupon_info set coupon_status=#{couponStatus} where coupon_sn=#{couponSn}")
    int updateCouponStatus(String couponSn,Integer couponStatus);

}
