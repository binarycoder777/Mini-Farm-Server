package com.cqut.atao.farm.coupon.domain.coupon.distribute;

import com.cqut.atao.farm.coupon.domain.common.Constant;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.repository.CouponRepository;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DistributeAbstract.java
 * @Description 优惠券分发抽象
 * @createTime 2023年03月13日 17:24:00
 */
@Slf4j
public abstract class DistributeAbstract implements Distribute {

    @Resource
    protected CouponRepository couponRepository;

    @Override
    public void distribute(CreateCouponReq req) {
        // 保存优惠券信息
        this.saveCoupon(req);
        // 筛选优惠券适用对象
        if (Constant.DISTRBUT_OBJECT.SCREENING.getCode().equals(req.getDistributeObject())) {
            // 保存关系
            this.saveCouponObject(req.getCouponSn(),req.getUserIdList());
        }
        // 筛选优惠券适用的指定商品
        if (Constant.COUPON_SCOPE.SPECIAL_PRODUCT.getCode().equals(req.getCouponScope())) {
            // 保存关系
            this.saveCouponProduct(req.getCouponSn(), req.getProductIdList());
        }
        // 筛选优惠券适用的指定类别商品
        if (Constant.COUPON_SCOPE.SPECIAL_TYPE.getCode().equals(req.getCouponScope())) {
            // 保存关系
            this.saveCouponProductType(req.getCouponSn(), req.getProductTypeIdList());
        }
        // 手动发放优惠券
        if (Constant.DISTRBUT_TYPE.ADMIN.getCode().equals(req.getDistributeType())) {
            // 手动发放优惠券
            this.adminDistributeCoupon(req);
        }
    }

    /**
     * 手动发放优惠券
     * @param req {@link CreateCouponReq}
     */
    protected abstract void adminDistributeCoupon(CreateCouponReq req);


    /**
     * 保存优惠券信息
     * @param req {@link CreateCouponReq}
     */
    public void saveCoupon(CreateCouponReq req) {
        log.info("保存优惠券信息");
        // 生成优惠券编码
        req.setCouponSn(CreateCouponReq.generateCouponSn());
        couponRepository.createCoupon(req);
    }


    /**
     * 保存优惠券适用商品范围关系（按商品）
     * @param couponSn 优惠券id
     * @param productTypeId 商品种类id列表
     */
    public void saveCouponProductType(String couponSn, List<Long> productTypeId) {
        log.info("保存优惠券适用商品范围关系");
    }

    /**
     * 保存优惠券适用商品范围关系（按种类）
     * @param couponSn 优惠券id
     * @param productId 商品id列表
     */
    public void saveCouponProduct(String couponSn, List<Long> productId) {
        log.info("保存优惠券适用商品范围关系（按种类）");
    }

    /**
     * 保存优惠券适用对象关系
     * @param couponSn 优惠券id
     * @param userId 用户id列表
     */
    public void saveCouponObject(String couponSn, List<Long> userId) {
        log.info("保存优惠券适用对象关系");
    }

}
