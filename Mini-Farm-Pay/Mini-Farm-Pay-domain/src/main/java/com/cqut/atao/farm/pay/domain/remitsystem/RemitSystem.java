package com.cqut.atao.farm.pay.domain.remitsystem;

import com.cqut.atao.farm.pay.domain.model.res.ClearingRecordRes;
import com.cqut.atao.farm.pay.domain.model.res.SettleInfoRes;
import com.cqut.atao.farm.pay.domain.model.res.SettleItemRes;
import com.cqut.atao.farm.pay.domain.repository.ClearingRecordRepository;
import com.cqut.atao.farm.pay.domain.repository.SettleRepository;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemitSystem.java
 * @Description 结算系统
 * @createTime 2023年03月03日 10:19:00
 */
@Component
@Slf4j
public class RemitSystem implements Remit {

    @Resource
    private ClearingRecordRepository clearingRecordRepository;

    @Resource
    private SettleRepository settleRepository;

    @Override
    public void remit(Long id) {
        // 查询账号对应的清分记录
        List<ClearingRecordRes> clearingRecordList = clearingRecordRepository.getClearingRecordList(id);
        // 合并记录
        SettleInfoRes settleInfoRes = mergeClearingRecord(clearingRecordList);
        // 保存结算单
        settleRepository.saveSettle(settleInfoRes);
        // 更新清算记录为已结算
        clearingRecordList.forEach(e->{
            clearingRecordRepository.updateClearingRecord(e);
        });
    }

    public SettleInfoRes mergeClearingRecord(List<ClearingRecordRes> clearingRecordList) {
        List<SettleItemRes> settleItemRes = BeanUtil.convert(clearingRecordList, SettleItemRes.class);
        SettleInfoRes settleInfoRes = SettleInfoRes.builder()
                .settleSn(SettleInfoRes.generateSettleSn())
                .itemList(settleItemRes)
                .build();
        return settleInfoRes;
    }
}
