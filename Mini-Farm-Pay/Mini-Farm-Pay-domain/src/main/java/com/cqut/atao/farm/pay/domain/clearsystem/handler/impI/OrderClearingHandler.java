package com.cqut.atao.farm.pay.domain.clearsystem.handler.impI;

import com.cqut.atao.farm.pay.domain.clearsystem.caculate.caculate.Caculate;
import com.cqut.atao.farm.pay.domain.clearsystem.caculate.caculate.impI.DefaultCaculator;
import com.cqut.atao.farm.pay.domain.clearsystem.handler.Clearing;
import com.cqut.atao.farm.pay.domain.model.res.ClearingRecordRes;
import com.cqut.atao.farm.pay.domain.remote.RemoteOrderService;
import com.cqut.atao.farm.pay.domain.remote.model.res.OrderInfoRes;
import com.cqut.atao.farm.pay.domain.repository.ClearingRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderClearingHandler.java
 * @Description 订单清分处理
 * @createTime 2023年03月02日 22:51:00
 */
@Component
@Slf4j
public class OrderClearingHandler implements Clearing {

    @Resource
    private DefaultCaculator defaultCaculator;

    @Resource
    private ClearingRecordRepository clearingRecordRepository;

    @Resource
    private RemoteOrderService remoteOrderService;

    @Override
    public void clearing(Object o) {
        String orderSn = (String)o;
        // 远程获取订单信息
        OrderInfoRes data = remoteOrderService.getOrderInfoByOrderSn(orderSn).getData();
        // 对象模型获取
        Object model = this.getObjectModel(data);
        // 查询计费规则
        Object rule = this.getObjectModel(data);
        // 计算服务计算
        List<ClearingRecordRes> clearingRecordResList = defaultCaculator.process(model,rule,data);
        // 存储清分记录
        clearingRecordRepository.batchSaveClearingRecord(clearingRecordResList);
        // 异步更新订单
        this.asyncUpdateOrderStatus(data);
    }



    public Object getObjectModel(Object o) {
        log.info("获取对象模型");
        return new Object();
    }

    public Object getCaculateRule(Object o) {
        log.info("查询计费规则");
        return new Object();
    }

    public void asyncUpdateOrderStatus(Object o) {
        log.info("异步更新订单状态为已清分");
    }

}
