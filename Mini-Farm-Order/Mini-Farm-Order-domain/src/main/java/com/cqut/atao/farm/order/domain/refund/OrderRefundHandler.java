package com.cqut.atao.farm.order.domain.refund;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.domain.operate.model.OperateRes;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyDetails;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyRes;
import com.cqut.atao.farm.order.domain.refund.model.req.ConfirmReturnOrderReq;
import com.cqut.atao.farm.order.domain.refund.model.req.ReturnOrderApplyReq;
import com.cqut.atao.farm.order.domain.refund.repository.OrderRefundRepository;
import com.cqut.atao.farm.order.domain.remote.RemotePayService;
import com.cqut.atao.farm.order.domain.stateflow.StateHandler;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private RemotePayService remotePayService;


    /**
     * 退货
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void returnProducts(ReturnOrderApplyReq req) {
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

    public void returnProductsConfirm(ConfirmReturnOrderReq req) {
        orderRefundRepository.orderRefundConfirm(req);
    }

    public void returnProductsRefuse(Long id) {
        orderRefundRepository.returnProductsRefuse(id);
    }

    public void returnOfgoodsRecive(Long id) {
        orderRefundRepository.returnOfgoodsRecive(id);
    }

    public void returnOfgoodsRefundMoney(String orderSn) {
        // 调用远程支付服务退款接口（已经涉及了退款、订单流转以及支付单流转）
//        remotePayService.notifyRefundMoney(orderSn);
        // 扭转退货申请单状态为已完成
        orderRefundRepository.returnOfgoodsReciveRefundMoney(orderSn);
    }

    public OrderReturnApplyDetails returnProductsDetailByOrderSn(String orderSn) {
        OrderReturnApplyDetails res = orderRefundRepository.orderRefundDetailByOrderSn(orderSn);
        return res;
    }
}
