package com.cqut.atao.farm.order.web.controller;

import com.cqut.atao.farm.order.application.statistics.DataStatistics;
import com.cqut.atao.farm.order.domain.model.aggregate.Order;
import com.cqut.atao.farm.order.domain.model.req.TimeQuantum;
import com.cqut.atao.farm.order.domain.model.res.OrderSalesVolume;
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
 * @ClassName OrderDataController.java
 * @Description 订单数据统计
 * @createTime 2023年05月01日 19:34:00
 */
@MiniLog
@RestController
@AllArgsConstructor
@Api(tags = "订单数据统计")
@RequestMapping("/api/order/data")
public class OrderDataController {

    @Resource
    private DataStatistics dataStatistics;

    @PostMapping("/sales/")
    @ApiOperation("销量|金额|日期")
    public Result<List<OrderSalesVolume>> orderDetail(@RequestBody TimeQuantum timeQuantum) {
        List<OrderSalesVolume> list = dataStatistics.orderSalesVolumeStatistics(timeQuantum.getStart(), timeQuantum.getEnd());
        return Results.success(list);
    }


}
