package com.cqut.atao.farm.order.infrastructure.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.order.domain.model.aggregate.OrderProduct;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyDetails;
import com.cqut.atao.farm.order.domain.refund.model.OrderReturnApplyRes;
import com.cqut.atao.farm.order.domain.refund.model.ReturnOrderApplyReq;
import com.cqut.atao.farm.order.domain.refund.repository.OrderRefundRepository;
import com.cqut.atao.farm.order.infrastructure.dao.OrderItemDAO;
import com.cqut.atao.farm.order.infrastructure.dao.OrderReturnApplyDAO;
import com.cqut.atao.farm.order.infrastructure.po.OrderItemPO;
import com.cqut.atao.farm.order.infrastructure.po.OrderReturnApply;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderRefundRepository.java
 * @Description 订单退货
 * @createTime 2023年04月23日 14:43:00
 */
@Repository
public class OrderRefundRepositoryImpI implements OrderRefundRepository {

    @Resource
    private OrderReturnApplyDAO orderReturnApplyDAO;

    @Resource
    private OrderItemDAO orderItemDAO;

    @Override
    public void addOrderReturnApply(ReturnOrderApplyReq req) {
        orderReturnApplyDAO.insert(BeanUtil.convert(req, OrderReturnApply.class));
    }

    @Override
    public PageResponse<OrderReturnApplyRes> pageSelectReturnApply(PageRequest request) {
        Page page = new Page(request.getCurrent(),request.getSize());
        Page selectPage = orderReturnApplyDAO.selectPage(page, null);
        return PageUtil.convert(selectPage,OrderReturnApply.class);
    }

    @Override
    public OrderReturnApplyDetails orderRefundDetail(Long id) {
        OrderReturnApplyDetails convert = BeanUtil.convert(orderReturnApplyDAO.selectById(id), OrderReturnApplyDetails.class);
        List<OrderItemPO> orderItemPOS = orderItemDAO.selectList(Wrappers.lambdaQuery(OrderItemPO.class).eq(OrderItemPO::getOrderSn, convert.getOrderSn()));
        convert.setOrderProductList(BeanUtil.convert(orderItemPOS, OrderProduct.class));
        return convert;
    }
}
