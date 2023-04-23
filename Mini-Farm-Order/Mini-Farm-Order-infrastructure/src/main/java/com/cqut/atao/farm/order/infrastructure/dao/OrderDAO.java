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

    @Update("<script>" +
            "update order_info set status=#{nextOrderState}" +
            "<if test = 'nextOrderState eq 2'> ,pay_time=now() </if>" +
            "where order_sn=#{orderId}" +
            "</script>")
    int alterOrderState(@Param("orderId") String orderId, @Param("currentOrderState") Integer currentOrderState, @Param("nextOrderState") Integer nextOrderState);


    @Select(
            "<script>" +
                    "select * from order_info where " +
                    "<if test='userId != null'> user_id = #{userId} and </if>" +
                    "status =#{orderStatus} and parent_id = id limit #{current},#{size}" +
                    "</script>"
    )
    List<OrderPO> pageParentOrder(OrderPageReq req);


    @Select("select * from order_info where order_sn = #{orderSn} and parent_id = id")
    OrderPO parentOrder(String orderSn);

    @Select("<script>" +
            "select * from order_info where" +
            " <if test='userId != null'> user_id = #{userId} and </if>" +
            " status =#{orderStatus} and parent_id != id limit #{current},#{size}" +
            "</script>")
    List<OrderPO> pageSubOrder(OrderPageReq req);

    @Select("<script>" +
            "select * from order_info where " +
            "<if test='userId != null'> user_id = #{userId} and </if>" +
            "status =#{orderStatus} and parent_id != id and parent_id=#{parentId}" +
            "</script>")
    List<OrderPO> listSubOrder(@Param("userId") Long userId, @Param("parentId") String parentId, @Param("orderStatus") Integer orderStatus);

    @Select("select * from order_info where  parent_id != id and parent_id=#{parentId}")
    List<OrderPO> subOrderList(@Param("parentId") String parentId);


    @Select("<script>" +
            "select count(*) from order_info where " +
            "<if test='userId != null'> user_id = #{userId} and </if>" +
            "status =#{orderStatus} and parent_id != id" +
            "</script>")
    int countSubOrder(Integer orderStatus);

    @Select("<script>" +
            "select count(*) from order_info where" +
            "<if test='userId != null'> user_id = #{userId} and </if>" +
            " status =#{orderStatus} and parent_id = id" +
            "</script>")
    int countParentOrder(Integer orderStatus);

}
