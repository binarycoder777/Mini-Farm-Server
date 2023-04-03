package com.cqut.atao.farm.pay.infrastructure.repository;

import com.cqut.atao.farm.pay.domain.model.res.ClearingRecordRes;
import com.cqut.atao.farm.pay.domain.repository.ClearingRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ClearingRecordRepositoryImpI.java
 * @Description 清分记录仓储类
 * @createTime 2023年04月03日 14:10:00
 */
@Repository
public class ClearingRecordRepositoryImpI implements ClearingRecordRepository {

    @Override
    public void batchSaveClearingRecord(List<ClearingRecordRes> clearingRecordRes) {

    }

    @Override
    public List<ClearingRecordRes> getClearingRecordList(Long id) {
        return null;
    }

    @Override
    public void updateClearingRecord(ClearingRecordRes clearingRecordRes) {

    }
}
