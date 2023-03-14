package com.cqut.atao.farm.coupon.domain.coupon.distribute;

import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import com.cqut.atao.farm.coupon.domain.coupon.repository.CouponRepository;
import com.cqut.atao.farm.coupon.domain.coupon.rule.RuleHandler;
import com.cqut.atao.farm.coupon.domain.remote.RemoteMessageService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DistributeCoupon.java
 * @Description 分发优惠券实现类
 * @createTime 2023年03月13日 16:11:00
 */
@Slf4j
@Component
public class DistributeCoupon extends DistributeAbstract{

    @Resource
    private RemoteMessageService remoteMessageService;

    @Resource
    private CouponRepository couponRepository;

    @Resource
    private RuleHandler ruleHandler;

    @Override
    protected void adminDistributeCoupon(CreateCouponReq req) {
        List<Long> userIdList = Lists.newLinkedList();
        // 规则过滤人群
        req.getUserIdList().forEach(e->{
            // 满足规则，放行
            if (ruleHandler.doFilter(e,req.getRuleType())) {
                userIdList.add(e);
            }
        });
        // 发放优惠券
        userIdList.forEach(e->{
             TakeCouponReq couponReq = TakeCouponReq.builder()
                    .couponSn(req.getCouponSn())
                    .userId(e)
                    .takeTime(new Date())
                    .build();
            couponRepository.takeCoupon(couponReq);
        });
        // 发送短信通知
        userIdList.forEach(e->{
            log.warn("发送邮件通知{}",e);
        });
    }

    @Override
    public void takeCoupon(TakeCouponReq req) {
        // 查询优惠券信息
        CouponRes coupon = couponRepository.getCoupon(req.getCouponSn());
        // 判断用户是否满足条件
        if (ruleHandler.doFilter(req.getUserId(),coupon.getRuleType())) {
            couponRepository.takeCoupon(req);
        }
        // 发送短信通知
        log.warn("发送邮件通知{}",req);
    }

    @Override
    public List<CouponRes> getCouponList(Long userId) {
        return couponRepository.getCouponList(userId);
    }

}
