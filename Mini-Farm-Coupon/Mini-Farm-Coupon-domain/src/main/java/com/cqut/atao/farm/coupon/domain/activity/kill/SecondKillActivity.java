package com.cqut.atao.farm.coupon.domain.activity.kill;


import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.DeployActivityReq;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.PassProductReq;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.res.KillACtivityRes;
import com.cqut.atao.farm.coupon.domain.activity.repository.KillRepository;
import com.cqut.atao.farm.coupon.domain.remote.RemoteOrderService;
import com.cqut.atao.farm.coupon.domain.remote.RemoteProductService;
import com.cqut.atao.farm.coupon.domain.remote.model.req.PlaceOrderReq;
import com.cqut.atao.farm.coupon.domain.remote.model.res.ProductSpuVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private RemoteProductService remoteProductService;


    public void deployActivity(DeployActivityReq req) {
        killRepository.createKill(req);
    }

    /**
     * 添加秒杀商品
     * @param req
     */
    public void addKillProduct(AddKillProductReq req) {
        // 添加商品
        killRepository.addKillActivity(req);
    }

    /**
     * 购买秒杀商品
     * @param req
     */
    public String buyKillProduct(PlaceOrderReq req) {
        // 异步下单
        remoteOrderService.createKillOrder(req);
        // 延迟取消
        log.warn("延迟取消订单");
        return "success";
    }

    /**
     * 查询秒杀活动场次
     * @return
     */
    public List<KillACtivityRes> queryKillActivity() {
        List<KillACtivityRes> list = killRepository.queryList();
        return list;
    }

    /**
     * 审批秒杀商品
     * @param req
     */
    public void passKillProduct(PassProductReq req) {
        if (!req.isPass()) {
            // 发送消息通知
            log.info("秒杀商品审批未通过:{}",req);
            // 审批未通过
            killRepository.passProduct(req.getId(),2);
            return;
        }
        // 审批通过
        killRepository.passProduct(req.getId(),1);
    }

    /**
     * 分页查询秒杀商品
     * @param killId
     * @return
     */
    public List<ProductSpuVO> pageQueryKillProduct(Long killId) {
        List<Long> spuIdList = killRepository.queryKillProduct(killId);
        List<ProductSpuVO> res = remoteProductService.getProductBySpuId(spuIdList).getData();
        return res;
    }


}
