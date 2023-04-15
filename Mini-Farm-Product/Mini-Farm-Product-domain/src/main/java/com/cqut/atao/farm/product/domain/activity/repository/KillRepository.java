package com.cqut.atao.farm.product.domain.activity.repository;


import com.cqut.atao.farm.product.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.product.domain.activity.kill.model.req.DeployActivityReq;
import com.cqut.atao.farm.product.domain.activity.kill.model.res.KillACtivityRes;

import java.util.List;

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

    /**
     * 查询秒杀活动场次
     * @return
     */
    List<KillACtivityRes> queryList();

    void passProduct(Long id, Integer i);

    List<Long> queryKillProduct(Long killId);
}
