package com.cqut.atao.farm.pay.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cqut.atao.farm.pay.domain.acquiresystem.model.aggreate.Payment;
import com.cqut.atao.farm.pay.domain.repository.PayInfoRepository;
import com.cqut.atao.farm.pay.infrastructure.dao.PayInfoDao;
import com.cqut.atao.farm.pay.infrastructure.po.PayInfo;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PayInfoRepositoryImpI.java
 * @Description 支付单仓储层接口实现类
 * @createTime 2023年02月24日 15:37:00
 */
@Repository
public class PayInfoRepositoryImpI implements PayInfoRepository {

    @Resource
    private PayInfoDao payInfoDao;

    @Override
    public boolean isExistPayment(String no) {
        return payInfoDao.exists(Wrappers.lambdaQuery(PayInfo.class).eq(PayInfo::getOrderSn,no));
    }

    @Override
    public void savePayment(Payment payment) {
        PayInfo payInfo = BeanUtil.convert(payment, PayInfo.class);
        int res = payInfoDao.insert(payInfo);
        Assert.isTrue(res > 0,()->new ServiceException("保存支付单异常"));
    }

    @Override
    public void alterPayment(String payNo, Integer nextState) {
        int res = payInfoDao.alertPaymentState(payNo,nextState);
        Assert.isTrue(res > 0, ()->new ServiceException("修改支付单状态异常"));
    }
}
