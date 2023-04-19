package com.cqut.atao.farm.coupon.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.UseCouponReq;
import com.cqut.atao.farm.coupon.infrastructure.po.Coupon;
import com.cqut.atao.farm.coupon.infrastructure.po.TakeCouponRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponMapper.java
 * @Description 领取优惠卷数据访问层接口
 * @createTime 2023年03月12日 15:0
 */
public interface TakeCouponMapper extends BaseMapper<TakeCouponRecord> {

    @Update("update take_coupon set order_sn=#{orderSn},use_status=1 where coupon_sn=#{couponSn} and user_id=#{userId}")
    int useCoupon(UseCouponReq useCouponReq);

}
