package com.cqut.atao.farm.pay.domain.repository;

import com.cqut.atao.farm.pay.domain.model.res.ClearingRecordRes;
import com.cqut.atao.farm.pay.domain.model.res.SettleInfoRes;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ClearingRecordRepository.java
 * @Description 结算仓储层接口
 * @createTime 2023年03月02日 15:14:00
 */
public interface SettleRepository {

    /**
     * 保存结算单
     * @param settleInfoRes
     */
    void saveSettle(SettleInfoRes settleInfoRes);

}
