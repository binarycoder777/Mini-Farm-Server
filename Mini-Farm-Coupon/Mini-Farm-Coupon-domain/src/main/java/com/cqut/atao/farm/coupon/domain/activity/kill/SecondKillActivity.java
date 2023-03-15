package com.cqut.atao.farm.coupon.domain.activity.kill;

import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.DeployActivityReq;
import com.cqut.atao.farm.coupon.domain.activity.repository.KillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SecondKillActivity.java
 * @Description 秒杀活动
 * @createTime 2023年03月14日 16:42:00
 */
@Component
@Slf4j
public class SecondKillActivity {

    @Resource
    private KillRepository killRepository;

    public void deployActivity(DeployActivityReq req) {
        killRepository.createKill(req);
    }

    public void addKillActivity(AddKillProductReq req) {
        // 锁定库存
        log.warn("锁定商品库存:{}",req);
        // 添加商品
        killRepository.addKillActivity(req);
    }

}
