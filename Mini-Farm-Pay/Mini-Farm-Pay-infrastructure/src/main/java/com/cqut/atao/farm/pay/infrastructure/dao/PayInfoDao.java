package com.cqut.atao.farm.pay.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.pay.infrastructure.po.PayInfo;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayInfoDao.java
 * @Description 支付单数据访问层接口
 * @createTime 2023年02月23日 14:57:00
 */
public interface PayInfoDao extends BaseMapper<PayInfo> {

    @Update("update pay_info set status=#{nextState} where paySn=#{payNo}")
    int alertPaymentState(String payNo, Integer nextState);

}
