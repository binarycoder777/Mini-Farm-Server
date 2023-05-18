package com.cqut.atao.farm.order.infrastructure.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cqut.atao.farm.order.domain.operate.model.OperateReq;
import com.cqut.atao.farm.order.domain.operate.model.OperateRes;
import com.cqut.atao.farm.order.domain.operate.repository.OrderOperateRecordRepository;
import com.cqut.atao.farm.order.infrastructure.dao.OrderOperateRecordDAO;
import com.cqut.atao.farm.order.infrastructure.po.OrderOperateRecord;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderOperateRecordRepositoryImpI.java
 * @Description 订单操作记录仓储层
 * @createTime 2023年04月24日 14:35:00
 */
@Repository
public class OrderOperateRecordRepositoryImpI implements OrderOperateRecordRepository {

    @Resource
    private OrderOperateRecordDAO orderOperateRecordDAO;

    @Override
    public List<OperateRes> list(String orderSn) {
        List<OrderOperateRecord> orderOperateRecords = orderOperateRecordDAO.selectList(Wrappers.lambdaQuery(OrderOperateRecord.class)
                .eq(OrderOperateRecord::getOrderSn, orderSn)
                .orderByAsc(OrderOperateRecord::getCreateTime));
        return BeanUtil.convert(orderOperateRecords,OperateRes.class);
    }

    @Override
    public void save(OperateReq req) {
        orderOperateRecordDAO.insert(BeanUtil.convert(req,OrderOperateRecord.class));
    }
}
