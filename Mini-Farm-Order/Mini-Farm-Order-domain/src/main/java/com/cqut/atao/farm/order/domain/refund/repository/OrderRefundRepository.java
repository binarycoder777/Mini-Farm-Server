package com.cqut.atao.farm.order.domain.refund.repository;

import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyDetails;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyRes;
import com.cqut.atao.farm.order.domain.refund.model.req.ConfirmReturnOrderReq;
import com.cqut.atao.farm.order.domain.refund.model.req.ReturnOrderApplyReq;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderRefundRepository.java
 * @Description 订单退货
 * @createTime 2023年04月23日 14:43:00
 */
public interface OrderRefundRepository {

    void addOrderReturnApply(ReturnOrderApplyReq req);

    PageResponse<OrderReturnApplyRes> pageSelectReturnApply(PageRequest request);

    OrderReturnApplyDetails orderRefundDetail(Long id);

    void orderRefundConfirm(ConfirmReturnOrderReq req);

    void returnProductsRefuse(Long id);
}
