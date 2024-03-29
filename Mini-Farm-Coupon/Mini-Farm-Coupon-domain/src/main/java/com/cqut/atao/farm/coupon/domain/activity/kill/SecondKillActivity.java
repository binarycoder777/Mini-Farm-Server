package com.cqut.atao.farm.coupon.domain.activity.kill;


import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.*;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.res.KillACtivityRes;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.res.KillProductRes;
import com.cqut.atao.farm.coupon.domain.activity.repository.KillRepository;
import com.cqut.atao.farm.coupon.domain.remote.RemoteOrderService;
import com.cqut.atao.farm.coupon.domain.remote.RemoteProductService;
import com.cqut.atao.farm.coupon.domain.remote.model.req.BatchQueryReq;
import com.cqut.atao.farm.coupon.domain.remote.model.req.PlaceOrderReq;
import com.cqut.atao.farm.coupon.domain.remote.model.res.Product;
import com.cqut.atao.farm.coupon.domain.remote.model.res.ProductRes;
import com.cqut.atao.farm.coupon.domain.remote.model.res.ProductSpuVO;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

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
    private RemoteProductService remoteProductService;


    public void deployActivity(DeployActivityReq req) {
        killRepository.createKill(req);
    }

    /**
     * 添加秒杀商品
     *
     * @param req
     */
    public void addKillProduct(AddKillProductReq req) {
        if (ObjectUtils.isEmpty(req.getProductSkuId())) {
            ProductRes data = remoteProductService.getProductBySpuId(req.getProductId() + "").getData();
            req.setProductSkuId(Long.valueOf(data.getProductSkus().get(0).getId()));
        }
        // 添加商品
        killRepository.addKillActivity(req);
    }

    /**
     * 购买秒杀商品
     *
     * @param req
     */
    public String buyKillProduct(KillOrderReq req) {
        // 扣减库存
        boolean lockRes = killRepository.lockStock(req.getId());
        // 异步下单
        String orderSn = remoteOrderService.createKillOrder(req.getReq()).getData();
        // 延迟取消
        log.warn("延迟取消订单");
        return orderSn;
    }

    /**
     * 查询秒杀活动场次
     *
     * @return
     */
    public List<KillACtivityRes> queryKillActivity() {
        List<KillACtivityRes> list = killRepository.queryList();
        return list;
    }

    /**
     * 审批秒杀商品
     *
     * @param req
     */
    public void passKillProduct(PassProductReq req) {
        if (!req.isPass()) {
            // 发送消息通知
            log.info("秒杀商品审批未通过:{}", req);
            // 审批未通过
            killRepository.passProduct(req.getId(), 2);
            return;
        }
        // 审批通过
        killRepository.passProduct(req.getId(), 1);
    }

    /**
     * 分页查询秒杀商品
     *
     * @param killId
     * @return
     */
    public List<KillProductRes> pageQueryKillProduct(Long killId) {
        List<KillProductRes> spuIdList = killRepository.queryKillProduct(killId);
        // 构造请求
        ArrayList<BatchQueryReq> productLists = Lists.newArrayList();
        for (int i = 0; i < spuIdList.size(); ++i) {
            BatchQueryReq build = BatchQueryReq.builder()
                    .productId(Long.valueOf(spuIdList.get(i).getProductId()))
                    .productSkuId(Long.valueOf(spuIdList.get(i).getProductSkuId()))
                    .build();
            productLists.add(build);
        }
        // 远程获取秒杀商品详情
        List<Product> res = remoteProductService.getProductBySpuId(productLists).getData();
        // 构造返回结果
        for (int i = 0; i < Math.min(spuIdList.size(),res.size()); ++i) {
            spuIdList.get(i).setProduct(res.get(i));
        }
        return spuIdList;
    }


    public void addKillNotice(addKillNoticeReq req) {
        killRepository.noticeKill(req);
    }

    public PageResponse<KillACtivityRes> activityPage(ActivityPageReq req) {
        return killRepository.activityPage(req);
    }

    public void activityStatus(Long id) {
        killRepository.activityStatus(id);
    }

    public void updateActivity(DeployActivityReq req) {
        killRepository.activityUpdate(req);
    }

    public void activityDelete(Long id) {
        killRepository.activityDelete(id);
    }

    public void updateKillProduct(AddKillProductReq req) {
        killRepository.updateKillProduct(req);
    }

    public List<KillProductRes> pageQueryKillProductAdmin(Long killId) {
        List<KillProductRes> spuIdList = killRepository.queryKillProductAdmin(killId);
        // 构造请求
        ArrayList<BatchQueryReq> productLists = Lists.newArrayList();
        for (int i = 0; i < spuIdList.size(); ++i) {
            BatchQueryReq build = BatchQueryReq.builder()
                    .productId(Long.valueOf(spuIdList.get(i).getProductId()))
                    .productSkuId(Long.valueOf(spuIdList.get(i).getProductSkuId()))
                    .build();
            productLists.add(build);
        }
        // 远程获取秒杀商品详情
        List<Product> res = remoteProductService.getProductBySpuId(productLists).getData();
        // 构造返回结果
        for (int i = 0; i < Math.min(spuIdList.size(),res.size()); ++i) {
            spuIdList.get(i).setProduct(res.get(i));
        }
        return spuIdList;
    }
}
