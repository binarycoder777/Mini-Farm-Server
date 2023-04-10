package com.cqut.atao.farm.order.infrastructure.repository;

import com.cqut.atao.farm.order.domain.model.req.ReturnProductReq;
import com.cqut.atao.farm.order.domain.repository.RefundProductRepository;
import com.cqut.atao.farm.order.infrastructure.dao.RefundProductDAO;
import com.cqut.atao.farm.order.infrastructure.po.RefundProduct;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RefundProductRepository.java
 * @Description 退货仓储层
 * @createTime 2023年04月10日 14:41:00
 */
@Repository
public class RefundProductRepositoryImpI implements RefundProductRepository {

    @Resource
    private RefundProductDAO refundProductDAO;

    @Override
    public void addRefundProductRecord(ReturnProductReq req) {
        RefundProduct convert = BeanUtil.convert(req, RefundProduct.class);
        refundProductDAO.insert(convert);
    }
}
