package com.cqut.atao.farm.coupon.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cqut.atao.farm.coupon.domain.common.Constant;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.UseCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import com.cqut.atao.farm.coupon.domain.coupon.repository.CouponRepository;
import com.cqut.atao.farm.coupon.infrastructure.dao.CouponMapper;
import com.cqut.atao.farm.coupon.infrastructure.dao.TakeCouponMapper;
import com.cqut.atao.farm.coupon.infrastructure.po.Coupon;
import com.cqut.atao.farm.coupon.infrastructure.po.TakeCouponRecord;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponRepository.java
 * @Description 优惠券仓储层实现类
 * @createTime 2023年03月12日 15:59:00
 */
@Slf4j
@Repository
public class CouponRepositoryImpI implements CouponRepository {

    @Resource
    private CouponMapper couponMapper;

    @Resource
    private TakeCouponMapper takeCouponMapper;


    @Override
    public void createCoupon(CreateCouponReq req) {
        Coupon coupon = BeanUtil.convert(req, Coupon.class);
        int insert = couponMapper.insert(coupon);
        Assert.isTrue(insert > 0, () -> new ServiceException("生成优惠券失败"));
    }

    @Override
    public CouponRes getCoupon(String couponSn) {
        Coupon coupon = couponMapper.selectOne(Wrappers.lambdaQuery(Coupon.class).eq(Coupon::getCouponSn,couponSn));
        return BeanUtil.convert(coupon, CouponRes.class);
    }

    @Override
    public void takeCoupon(TakeCouponReq req) {
        log.warn("扣减优惠券库存!!!");
        TakeCouponRecord record = BeanUtil.convert(req, TakeCouponRecord.class);
        int res = takeCouponMapper.insert(record);
        Assert.isTrue(res > 0, () -> new ServiceException("优惠券领取记录保存失败"));
    }

    @Override
    public List<CouponRes> getCouponList(Long userId) {
        List<String> couponSns = takeCouponMapper.selectList(Wrappers.lambdaQuery(TakeCouponRecord.class)
                .eq(TakeCouponRecord::getUserId, userId)).stream()
                .map(e -> {
                    return e.getCouponSn();
                }).collect(Collectors.toList());
        List<Coupon> couponList = Lists.newArrayList();
        for (String e: couponSns) {
            Coupon coupon = couponMapper.selectOne(Wrappers.lambdaQuery(Coupon.class).eq(Coupon::getCouponSn, e));
            if (!judgeConponValid(coupon)) {
                continue;
            }
            couponList.add(coupon);
        }
        return BeanUtil.convert(couponList,CouponRes.class);
    }

    @Override
    public void useCoupon(UseCouponReq req) {
        Coupon coupon = couponMapper.selectOne(Wrappers.lambdaQuery(Coupon.class).eq(Coupon::getCouponSn, req.getCouponSn()));
        if (!judgeConponValid(coupon)) {
            return;
        }
        takeCouponMapper.delete(Wrappers.lambdaQuery(TakeCouponRecord.class)
        .eq(TakeCouponRecord::getUserId,req.getUserId())
        .eq(TakeCouponRecord::getCouponSn,req.getCouponSn()));
    }


    public boolean judgeConponValid(Coupon coupon) {
        if (!coupon.isValidaty()) {
            couponMapper.updateCouponStatus(coupon.getCouponSn(), Constant.COUPON_STATUS.INVALID.getCode());
            log.info("优惠券已失效:{}",coupon);
            return false;
        }
        return true;
    }

}
