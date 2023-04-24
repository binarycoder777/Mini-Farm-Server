package com.cqut.atao.farm.order.domain.operate.repository;

import com.cqut.atao.farm.order.domain.operate.model.OperateReq;
import com.cqut.atao.farm.order.domain.operate.model.OperateRes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderOperateRecordRepositoryImpI.java
 * @Description 订单操作记录仓储层
 * @createTime 2023年04月24日 14:35:00
 */
public interface OrderOperateRecordRepository {

    List<OperateRes> list(String orderSn);

    void save(OperateReq req);
}
