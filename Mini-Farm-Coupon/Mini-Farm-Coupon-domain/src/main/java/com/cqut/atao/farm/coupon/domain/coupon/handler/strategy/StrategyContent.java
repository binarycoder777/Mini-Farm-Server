package com.cqut.atao.farm.coupon.domain.coupon.handler.strategy;

import com.cqut.atao.farm.coupon.domain.coupon.common.Constant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName StrategyContent.java
 * @Description 策略上下文
 * @createTime 2023年04月18日 10:48:00
 */
@Component
public class StrategyContent {

    @Resource
    private FullReductionStrategy fullReductionStrategy;

    @Resource
    private FullDiscountOfNumStrategy fullDiscountOfNumStrategy;

    @Resource
    private ProductScopeStrategy productScopeStrategy;

    @Resource
    private CategoryScopeStrategy categoryScopeStrategy;

    public final Map<Constant.CouponFilter,CouponStrategy> group = new ConcurrentHashMap<>();

    @PostConstruct
    private void init() {
        group.put(Constant.CouponFilter.FULL_REDUCTION,fullReductionStrategy);
        group.put(Constant.CouponFilter.FULL_DISCOIUNT_NUM,fullDiscountOfNumStrategy);
        group.put(Constant.CouponFilter.PRODUCT_SCOPE,productScopeStrategy);
        group.put(Constant.CouponFilter.CATEGORY_SCOPE,categoryScopeStrategy);
    }

}
