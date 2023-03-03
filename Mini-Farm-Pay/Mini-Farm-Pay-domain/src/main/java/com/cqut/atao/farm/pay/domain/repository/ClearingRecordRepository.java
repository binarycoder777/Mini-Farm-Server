package com.cqut.atao.farm.pay.domain.repository;

import com.cqut.atao.farm.pay.domain.model.res.ClearingRecordRes;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ClearingRecordRepository.java
 * @Description 清分记录仓储层接口
 * @createTime 2023年03月02日 15:14:00
 */
public interface ClearingRecordRepository {

    /**
     * 批量存储清分记录
     * @param clearingRecordRes
     */
    void batchSaveClearingRecord(List<ClearingRecordRes> clearingRecordRes);

    /**
     * 通过用户id获取清分记录列表
     * @param id 用户id
     * @return 清分记录
     */
    List<ClearingRecordRes> getClearingRecordList(Long id);


    /**
     * 更新清分记录
     * @param clearingRecordRes
     */
    void updateClearingRecord(ClearingRecordRes clearingRecordRes);

}
