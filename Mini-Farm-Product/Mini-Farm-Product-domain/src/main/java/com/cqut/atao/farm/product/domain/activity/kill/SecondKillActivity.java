package com.cqut.atao.farm.product.domain.activity.kill;


import com.cqut.atao.farm.product.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.product.domain.activity.kill.model.req.DeployActivityReq;
import com.cqut.atao.farm.product.domain.activity.kill.model.req.PassProductReq;
import com.cqut.atao.farm.product.domain.activity.kill.model.res.KillACtivityRes;
import com.cqut.atao.farm.product.domain.activity.repository.KillRepository;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderItemInfo;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.domain.remote.RemoteOrderService;
import com.cqut.atao.farm.product.domain.remote.model.req.PlaceOrderReq;
import com.cqut.atao.farm.product.domain.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private ProductRepository productRepository;

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
    public void buyKillProduct(PlaceOrderReq req) {

        // 异步下单
        remoteOrderService.createKillOrder(req);
        // 延迟取消
        log.warn("延迟取消订单");
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
    @Transactional
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
        // 锁定库存
        log.warn("锁定商品库存:{}",req);
        OrderItemInfo build = OrderItemInfo.builder()
                .num(req.getNum())
                .skuId(req.getProductSkuId())
                .build();
        List<OrderItemInfo> list = new ArrayList<>();
        list.add(build);
         OrderInfo build1 = OrderInfo.builder()
                .orderItemInfos(list)
                .build();
        productRepository.lockProductStock(build1);
    }

    /**
     * 分页查询秒杀商品
     * @param killId
     * @return
     */
    public List<ProductSpuVO> pageQueryKillProduct(Long killId) {
        List<Long> spuIdList = killRepository.queryKillProduct(killId);
        List<ProductSpuVO> res = productRepository.queryProductList(spuIdList);
        return res;
    }

}
