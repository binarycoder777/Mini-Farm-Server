package com.cqut.atao.farm.order.infrastructure.repository.status;

import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.OrderPageReq;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName pageQueryOrderInfo.java
 * @Description 分页查询订单信息（对前后端状态码表不一致做适配）
 * @createTime 2023年04月04日 08:58:00
 */
public interface PageQueryOrderInfo {

    /**
     * 分页查询订单信息
     * @param req {@link OrderPageReq req}
     * @return 分页结果
     */
    PageResponse<Order> queryOrderPageInfo(OrderPageReq req);

}
