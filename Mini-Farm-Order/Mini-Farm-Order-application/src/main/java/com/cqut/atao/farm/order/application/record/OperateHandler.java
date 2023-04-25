package com.cqut.atao.farm.order.application.record;

import com.cqut.atao.farm.order.domain.common.HostHolder;
import com.cqut.atao.farm.order.domain.operate.model.OperateReq;
import com.cqut.atao.farm.order.domain.operate.repository.OrderOperateRecordRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OperateHandler.java
 * @Description 操作处理
 * @createTime 2023年04月25日 14:45:00
 */
@Component
public class OperateHandler implements Operate{

    @Resource
    private HostHolder hostHolder;

    @Resource
    private OrderOperateRecordRepository orderOperateRecordRepository;

    @Override
    public void doOperate(String orderSn,Integer eventType,String note) {
        if (hostHolder.getUser() == null) {
            return;
        }
         OperateReq build = OperateReq.builder()
                .operateMan(hostHolder.getUser().getName())
                .createTime(new Date())
                .orderSn(orderSn)
                .eventType(eventType)
                .note(note)
                .build();
         orderOperateRecordRepository.save(build);
    }
}
