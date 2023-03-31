package com.cqut.atao.farm.order.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.order.infrastructure.po.OrderPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderDAO.java
 * @Description 订单数据持久层
 * @createTime 2023年02月04日 15:09:00
 */
public interface OrderDAO extends BaseMapper<OrderPO> {

    @Update("update order_info set status=#{nextOrderState} where order_sn=#{orderId} and status=#{currentOrderState}")
    int alterOrderState(String orderId, Enum<Constants.OrderState> currentOrderState, Enum<Constants.OrderState> nextOrderState);

    @Select("select * from order_info where user_id = #{userId} and status =#{orderStatus} and parent_id = id limit #{current},#{size}")
    List<OrderPO> pageParentOrder(OrderPageReq req);

    @Select("select * from order_info where user_id = #{userId} and status =#{orderStatus} and parent_id != id limit #{current},#{size}")
    List<OrderPO> pageSubOrder(OrderPageReq req);

    @Select("select * from order_info where user_id = #{userId} and status =#{orderStatus} and parent_id != id and parent_id=#{parentId}")
    List<OrderPO> listSubOrder(@Param("userId") Long userId,@Param("parentId") String parentId,@Param("orderStatus") Integer orderStatus);

    @Select("select count(*) from order_info where status =#{orderStatus} and parent_id != id")
    int countSubOrder(Integer orderStatus);

    @Select("select count(*) from order_info where status =#{orderStatus} and parent_id = id")
    int countParentOrder(Integer orderStatus);

}
