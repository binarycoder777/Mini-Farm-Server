package com.cqut.atao.farm.coupon.domain.activity.repository;

import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.DeployActivityReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ActivityRepository.java
 * @Description 秒杀仓储接口
 * @createTime 2023年03月14日 21:08:00
 */
public interface KillRepository {

    /**
     * 创建秒杀活动
     * @param req {@link DeployActivityReq}
     */
    void createKill(DeployActivityReq req);


    /**
     * 添加秒杀商品
     * @param req {@link AddKillProductReq}
     */
    void addKillActivity(AddKillProductReq req);


}
