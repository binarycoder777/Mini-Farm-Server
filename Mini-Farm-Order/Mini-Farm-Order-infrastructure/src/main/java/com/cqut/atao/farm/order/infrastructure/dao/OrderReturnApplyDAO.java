package com.cqut.atao.farm.order.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.order.infrastructure.po.OrderReturnApply;
import com.cqut.atao.farm.order.infrastructure.po.RefundProduct;
import org.apache.ibatis.annotations.Select;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RefundProductDAO.java
 * @Description 退货 dao 层
 * @createTime 2023年04月10日 14:39:00
 */
public interface OrderReturnApplyDAO extends BaseMapper<OrderReturnApply> {

    @Select("select count(*) from order_return_apply where status=0")
    int waitReturnOrder();

    @Select("select count(*) from order_return_apply where status=1")
    int waitConfirmReturnOrder();

    @Select("select count(*) from order_return_apply where status=2")
    int waitConfirmRefundOrder();
}
