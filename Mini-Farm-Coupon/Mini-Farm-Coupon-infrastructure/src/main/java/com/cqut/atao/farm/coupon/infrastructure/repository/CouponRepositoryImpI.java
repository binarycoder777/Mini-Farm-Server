package com.cqut.atao.farm.coupon.infrastructure.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.atao.farm.coupon.domain.common.Constant;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.UseCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.TakeCouponRecordRes;
import com.cqut.atao.farm.coupon.domain.coupon.repository.CouponRepository;
import com.cqut.atao.farm.coupon.infrastructure.dao.CouponMapper;
import com.cqut.atao.farm.coupon.infrastructure.dao.TakeCouponMapper;
import com.cqut.atao.farm.coupon.infrastructure.po.Coupon;
import com.cqut.atao.farm.coupon.infrastructure.po.TakeCouponRecord;
import com.cqut.atao.farm.mybatisplus.springboot.starter.util.PageUtil;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
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
        Coupon coupon = couponMapper.selectOne(Wrappers.lambdaQuery(Coupon.class)
                .eq(Coupon::getCouponSn, couponSn));
        return BeanUtil.convert(coupon, CouponRes.class);
    }

    @Override
    public void takeCoupon(TakeCouponReq req) {
        log.warn("扣减优惠券库存!!!");
        TakeCouponRecord record = BeanUtil.convert(req, TakeCouponRecord.class);
        record.setUseStatus(0);
        int res = takeCouponMapper.insert(record);
        Assert.isTrue(res > 0, () -> new ServiceException("优惠券领取记录保存失败"));
    }

    @Override
    public List<CouponRes> getCouponList(Long userId) {
        List<String> couponSns = takeCouponMapper.selectList(Wrappers.lambdaQuery(TakeCouponRecord.class)
                .eq(TakeCouponRecord::getUserId, userId)
                .eq(TakeCouponRecord::getUseStatus, 0)).stream()
                .map(e -> {
                    return e.getCouponSn();
                }).collect(Collectors.toList());
        List<Coupon> couponList = Lists.newArrayList();
        for (String e : couponSns) {
            Coupon coupon = couponMapper.selectOne(Wrappers.lambdaQuery(Coupon.class).eq(Coupon::getCouponSn, e));
            if (!judgeConponValid(coupon)) {
                continue;
            }
            couponList.add(coupon);
        }
        return BeanUtil.convert(couponList, CouponRes.class);
    }

    @Override
    public void useCoupon(UseCouponReq req) {
        // 消费优惠券
        takeCouponMapper.useCoupon(req);
    }


    public boolean judgeConponValid(Coupon coupon) {
        if (!coupon.isValidaty()) {
            couponMapper.updateCouponStatus(coupon.getCouponSn(), Constant.COUPON_STATUS.INVALID.getCode());
            log.info("优惠券已失效:{}", coupon);
            return false;
        }
        return true;
    }


    @Override
    public List<CouponRes> queryInvalidCouponList(Long userId) {
        List<String> couponSns = takeCouponMapper.selectList(Wrappers.lambdaQuery(TakeCouponRecord.class)
                .eq(TakeCouponRecord::getUserId, userId)).stream()
                .map(e -> {
                    return e.getCouponSn();
                }).collect(Collectors.toList());
        List<Coupon> couponList = Lists.newArrayList();
        for (String e : couponSns) {
            Coupon coupon = couponMapper.selectOne(Wrappers.lambdaQuery(Coupon.class).eq(Coupon::getCouponSn, e));
            if (judgeConponValid(coupon)) {
                continue;
            }
            couponList.add(coupon);
        }
        return BeanUtil.convert(couponList, CouponRes.class);
    }


    @Override
    public PageResponse<CouponRes> couponList(PageRequest req, String name, Integer type) {
        Page<Coupon> couponPage = new Page<>(req.getCurrent(), req.getSize());
        LambdaQueryWrapper<Coupon> couponLambdaQueryWrapper = Wrappers.lambdaQuery(Coupon.class);
        if (StringUtils.isNotEmpty(name)) {
            couponLambdaQueryWrapper = couponLambdaQueryWrapper.like(Coupon::getCouponName, name);
        }
        if (!ObjectUtils.isEmpty(type)) {
            couponLambdaQueryWrapper = couponLambdaQueryWrapper.eq(Coupon::getCouponType, type);
        }
        Page<Coupon> couponPage1 = couponMapper.selectPage(couponPage, couponLambdaQueryWrapper);
        return PageUtil.convert(couponPage1,CouponRes.class);
    }

    @Override
    public CouponRes couponDetail(Long id) {
        return BeanUtil.convert(couponMapper.selectById(id),CouponRes.class);
    }

    @Override
    public PageResponse<TakeCouponRecordRes> couponHistory(PageRequest req, String couponSn) {
        Page<TakeCouponRecord> page = new Page<>(req.getCurrent(),req.getSize());
        Page<TakeCouponRecord> page1 = takeCouponMapper.selectPage(page, Wrappers.lambdaQuery(TakeCouponRecord.class).eq(TakeCouponRecord::getCouponSn, couponSn));
        return PageUtil.convert(page1,TakeCouponRecordRes.class);
    }

    @Override
    public Long couponUseNum(String couponSn) {
        return takeCouponMapper.selectCount(Wrappers.lambdaQuery(TakeCouponRecord.class).eq(TakeCouponRecord::getCouponSn,couponSn).eq(TakeCouponRecord::getUseStatus,1));
    }

    @Override
    public void updateCoupon(CreateCouponReq req) {
        couponMapper.updateById(BeanUtil.convert(req,Coupon.class));
    }

    @Override
    public void couponDelete(String id) {
        couponMapper.deleteById(id);
    }
}
