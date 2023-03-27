package com.cqut.atao.farm.coupon.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.DeployActivityReq;
import com.cqut.atao.farm.coupon.domain.activity.repository.KillRepository;
import com.cqut.atao.farm.coupon.infrastructure.dao.KillInSecondsMapper;
import com.cqut.atao.farm.coupon.infrastructure.dao.SecondKillProductMapper;
import com.cqut.atao.farm.coupon.infrastructure.po.KillsInSeconds;
import com.cqut.atao.farm.coupon.infrastructure.po.SecondKillProduct;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName KillRepositoryImpI.java
 * @Description 秒杀仓储实现层
 * @createTime 2023年03月14日 15:35:00
 */
@Component
public class KillRepositoryImpI implements KillRepository {

    @Resource
    private KillInSecondsMapper killInSecondsMapper;

    @Resource
    private SecondKillProductMapper secondKillProductMapper;

    @Override
    public void createKill(DeployActivityReq req) {
        KillsInSeconds killsInSeconds = BeanUtil.convert(req, KillsInSeconds.class);
        int i = killInSecondsMapper.insert(killsInSeconds);
        Assert.isTrue(i>0,()->new ServiceException("保存秒杀场次失败"));
    }

    @Override
    public void addKillActivity(AddKillProductReq req) {
        SecondKillProduct killProduct = BeanUtil.convert(req, SecondKillProduct.class);
        int i = secondKillProductMapper.insert(killProduct);
        Assert.isTrue(i>0,()->new ServiceException("保存秒杀商品失败"));
    }
}
