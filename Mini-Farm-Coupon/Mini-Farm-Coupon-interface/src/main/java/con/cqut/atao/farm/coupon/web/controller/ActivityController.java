package con.cqut.atao.farm.coupon.web.controller;

import com.cqut.atao.farm.coupon.domain.activity.kill.SecondKillActivity;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.AddKillProductReq;
import com.cqut.atao.farm.coupon.domain.activity.kill.model.req.DeployActivityReq;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import com.cqut.atao.farm.springboot.starter.web.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ActivityController.java
 * @Description 活动控制
 * @createTime 2023年03月14日 13:55:00
 */
@MiniLog
@AllArgsConstructor
@Api(tags = "平台活动")
@RestController
@RequestMapping("/api/promotion/activity")
public class ActivityController {

    @Resource
    private SecondKillActivity secondKillActivity;

    @PostMapping("/kill/create")
    @ApiOperation(value = "创建秒杀场次")
    public Result<Void> createKillSeconds(@RequestBody DeployActivityReq req) {
        secondKillActivity.deployActivity(req);
        return Results.success();
    }

    @PostMapping("/kill/product/add")
    @ApiOperation(value = "添加秒杀商品")
    public Result<Void> addKillProduct(@RequestBody AddKillProductReq req) {
        secondKillActivity.addKillActivity(req);
        return Results.success();
    }

}
