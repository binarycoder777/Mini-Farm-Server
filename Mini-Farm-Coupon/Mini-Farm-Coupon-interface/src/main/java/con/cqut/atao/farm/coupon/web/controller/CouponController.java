package con.cqut.atao.farm.coupon.web.controller;

import com.cqut.atao.farm.coupon.application.CouponService;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.CreateCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.TakeCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.req.UseCouponReq;
import com.cqut.atao.farm.coupon.domain.coupon.model.res.CouponRes;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponController.java
 * @Description 优惠卷controller类
 * @createTime 2023年03月12日 13:47:00
 */
@MiniLog
@AllArgsConstructor
@Api(tags = "优惠券")
@RestController
@RequestMapping("/api/promotion/coupon")
public class CouponController {

    @Resource
    private CouponService couponService;

    @PostMapping("/create")
    @ApiOperation(value = "生成优惠卷")
    public Result<Void> createCoupon(@RequestBody CreateCouponReq req) {
        couponService.generateCoupon(req);
        return Results.success();
    }

    @PostMapping("/take")
    @ApiOperation(value = "领取优惠卷")
    public Result<Void> takeCoupon(@RequestBody TakeCouponReq req) {
        couponService.takeCoupon(req);
        return Results.success();
    }

    @PutMapping("/consume")
    @ApiOperation(value = "消费优惠卷")
    public Result<Void> consumeCoupon(@RequestBody UseCouponReq req) {
        couponService.useCoupon(req);
        return Results.success();
    }

    @GetMapping("/get/{userId}")
    @ApiOperation(value = "查看自身的优惠券")
    public Result<List<CouponRes>> getCoupon(@PathVariable("userId") Long userId) {
        List<CouponRes> couponList = couponService.getCouponList(userId);
        return Results.success(couponList);
    }

}