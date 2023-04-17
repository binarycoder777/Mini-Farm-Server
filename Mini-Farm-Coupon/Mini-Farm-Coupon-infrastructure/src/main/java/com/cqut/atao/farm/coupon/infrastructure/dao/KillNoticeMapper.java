package com.cqut.atao.farm.coupon.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.coupon.infrastructure.po.Coupon;
import com.cqut.atao.farm.coupon.infrastructure.po.KillNotice;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponMapper.java
 * @Description 秒杀提醒数据访问层接口
 * @createTime 2023年03月12日 15:57:00
 */
public interface KillNoticeMapper extends BaseMapper<KillNotice> {

}
