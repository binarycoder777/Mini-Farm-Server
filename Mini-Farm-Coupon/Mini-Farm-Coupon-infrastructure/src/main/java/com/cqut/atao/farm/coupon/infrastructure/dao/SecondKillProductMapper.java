package com.cqut.atao.farm.coupon.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.coupon.infrastructure.po.KillsInSeconds;
import com.cqut.atao.farm.coupon.infrastructure.po.SecondKillProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponMapper.java
 * @Description 秒杀场次数据访问层接口
 * @createTime 2023年03月12日 15:0
 */
public interface SecondKillProductMapper extends BaseMapper<SecondKillProduct> {

    @Update("update second_kill_products set status=#{status} where id=#{id}")
    int unpdateStatus(@Param("id") Long id,@Param("status") Integer status);

    @Update("update second_kill_products set kill_num=(kill_num-1) where id=#{id} and kill_num > 0")
    int lockStock(@Param("id") Long id);
}
