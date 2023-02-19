package com.cqut.atao.farm.order.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.infrastructure.po.OrderPO;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderDAO.java
 * @Description 订单数据持久层
 * @createTime 2023年02月04日 15:09:00
 */
public interface OrderDAO extends BaseMapper<OrderPO> {

    @Update("update order_info set status=#{nextOrderState} where order_sn=#{orderId} and status=#{currentOrderState}")
    int alterOrderState(Long orderId, Enum<Constants.OrderState> currentOrderState, Enum<Constants.OrderState> nextOrderState);

}
