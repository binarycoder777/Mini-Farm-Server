package com.cqut.atao.farm.order.domain.operate;

import com.cqut.atao.farm.order.domain.operate.model.OperateReq;
import com.cqut.atao.farm.order.domain.operate.model.OperateRes;
import com.cqut.atao.farm.order.domain.operate.repository.OrderOperateRecordRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OperateHandler.java
 * @Description 操作处理
 * @createTime 2023年04月24日 14:38:00
 */
@Service
public class OrderOperateHandler {

    @Resource
    private OrderOperateRecordRepository orderOperateRecordRepository;

    public List<OperateRes> operateList(String orderSn) {
        return orderOperateRecordRepository.list(orderSn);
    }

    public void operateOrder(OperateReq req) {
        orderOperateRecordRepository.save(req);
    }
}
