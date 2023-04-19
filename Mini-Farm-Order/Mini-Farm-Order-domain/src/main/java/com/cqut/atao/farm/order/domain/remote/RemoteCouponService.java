package com.cqut.atao.farm.order.domain.remote;

import com.cqut.atao.farm.order.domain.remote.model.req.UseCouponReq;
import com.cqut.atao.farm.order.domain.remote.model.res.CouponRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteCouponService.java
 * @Description 远程优惠券服务
 * @createTime 2023年04月18日 16:08:00
 */
@FeignClient("coupon")
public interface RemoteCouponService {

    @PutMapping("/api/promotion/coupon/consume")
    @ApiOperation(value = "消费优惠卷")
    Result<Void> consumeCoupon(@RequestBody UseCouponReq req);

    @GetMapping("/coupon/{couponSn}")
    @ApiOperation(value = "根据编号查询优惠券")
    Result<CouponRes> getCoupon(@PathVariable("couponSn") String couponSn);

}
