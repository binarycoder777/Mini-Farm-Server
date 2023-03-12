package con.cqut.atao.farm.coupon.web.controller;

import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CouponController.java
 * @Description 优惠卷controller类
 * @createTime 2023年03月12日 13:47:00
 */
@MiniLog
@AllArgsConstructor
@Api(tags = "购物车")
@RestController
@RequestMapping("/api/promotion/coupon")
public class CouponController {

    @PostMapping("/take")
    @ApiOperation(value = "领取优惠卷")
    public Result<Void> takeCoupon() {

        return Results.success();
    }

}
