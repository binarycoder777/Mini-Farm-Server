package com.cqut.atao.farm.coupon.domain.coupon.distribute;

import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.repository.TakeCouponRepository;
import com.cqut.atao.farm.coupon.domain.remote.RemoteMessageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DistributeCoupon.java
 * @Description 分发优惠券实现类
 * @createTime 2023年03月13日 16:11:00
 */
@Component
public class DistributeCoupon extends DistributeAbstract{

    @Resource
    private RemoteMessageService remoteMessageService;

    @Resource
    private TakeCouponRepository takeCouponRepository;

    @Override
    protected void adminDistributeCoupon(CreateCouponReq req) {
        // 规则过滤人群

        // 发放优惠券

        // 发送短信通知

    }
}
