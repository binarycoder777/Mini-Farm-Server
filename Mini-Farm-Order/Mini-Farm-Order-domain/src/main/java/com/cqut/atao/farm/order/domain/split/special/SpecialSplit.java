package com.cqut.atao.farm.order.domain.split.special;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SpecialSplit.java
 * @Description 优惠分摊接口
 * @createTime 2023年02月27日 10:54:00
 */
public interface SpecialSplit {

    Order cacualte(Order order);

}
