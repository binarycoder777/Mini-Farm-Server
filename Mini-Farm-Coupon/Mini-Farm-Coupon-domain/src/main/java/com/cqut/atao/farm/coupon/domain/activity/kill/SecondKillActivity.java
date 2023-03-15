package com.cqut.atao.farm.coupon.domain.activity.kill;

import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.DeployActivityReq;
import com.cqut.atao.farm.coupon.domain.activity.repository.KillRepository;
import com.cqut.atao.farm.coupon.domain.remote.RemoteOrderService;
import com.cqut.atao.farm.coupon.domain.remote.model.req.PlaceOrderReq;
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

    @Resource
    private RemoteOrderService remoteOrderService;

    public void deployActivity(DeployActivityReq req) {
        killRepository.createKill(req);
    }

    public void addKillProduct(AddKillProductReq req) {
        // 添加商品
        killRepository.addKillActivity(req);
    }

    public void buyKillProduct(PlaceOrderReq req) {
        // 锁定库存
        log.warn("锁定商品库存:{}",req);
        // 异步下单
        remoteOrderService.createKillOrder(req);
        // 延迟取消
        log.warn("延迟取消订单");
    }

}
