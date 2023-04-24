package com.cqut.atao.farm.order.domain.refund;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyDetails;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyRes;
import com.cqut.atao.farm.order.domain.refund.model.ReturnOrderApplyReq;
import com.cqut.atao.farm.order.domain.refund.repository.OrderRefundRepository;
import com.cqut.atao.farm.order.domain.stateflow.StateHandler;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderRefund.java
 * @Description 用户退货
 * @createTime 2023年04月23日 14:34:00
 */
@Service
public class OrderRefundHandler {

    @Resource
    private OrderRefundRepository orderRefundRepository;

    @Resource
    private StateHandler stateHandler;


    /**
     * 退货
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void returnProducts(ReturnOrderApplyReq req) {
        // 数组转字符串
        req.picToStr();
        // 处理退货
        orderRefundRepository.addOrderReturnApply(req);
        // 订单状态流转
        stateHandler.returnProduct(req.getOrderSn(), Constants.OrderState.WAIT_SIGNATURE);
    }

    public PageResponse<OrderReturnApplyRes> returnProductsList(PageRequest request) {
        return orderRefundRepository.pageSelectReturnApply(request);
    }

    public OrderReturnApplyDetails returnProductsDetail(Long id) {
        OrderReturnApplyDetails res = orderRefundRepository.orderRefundDetail(id);

        return res;
    }
}
