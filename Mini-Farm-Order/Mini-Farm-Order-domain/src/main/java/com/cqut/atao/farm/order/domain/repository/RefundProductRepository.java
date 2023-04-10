package com.cqut.atao.farm.order.domain.repository;

import com.cqut.atao.farm.order.domain.model.req.ReturnProductReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RefundProductRepository.java
 * @Description 退货仓储层接口
 * @createTime 2023年04月10日 14:44:00
 */
public interface RefundProductRepository {

    void addRefundProductRecord(ReturnProductReq req);
}
