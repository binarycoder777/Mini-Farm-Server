package com.cqut.atao.farm.coupon.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.coupon.infrastructure.po.KillsInSeconds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponMapper.java
 * @Description 秒杀场次数据访问层接口
 * @createTime 2023年03月12日 15:0
 */
public interface KillInSecondsMapper extends BaseMapper<KillsInSeconds> {

    @Update("<script>" +
            "update second_kill set " +
            "<if test='status=1'> status=0 </if>" +
            "<if test='status=0'> status=1 </if>" +
            "where id=#{id}" +
            "</script>")
    int activityStatus(@Param("id")Long id);

}
