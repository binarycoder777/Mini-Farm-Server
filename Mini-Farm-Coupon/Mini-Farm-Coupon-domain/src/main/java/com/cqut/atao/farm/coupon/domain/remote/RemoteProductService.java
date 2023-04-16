package com.cqut.atao.farm.coupon.domain.remote;

import com.cqut.atao.farm.coupon.domain.remote.model.res.ProductSpuVO;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteProductService.java
 * @Description 远程商品服务
 * @createTime 2023年04月16日 10:22:00
 */
@FeignClient("product")
public interface RemoteProductService {

    @PostMapping("/api/product/bach/query/spu/")
    @ApiOperation(value = "根据 spuId 查询商品SPU")
    public Result<List<ProductSpuVO>> getProductBySpuId(@RequestBody List<Long> spuIds);

}
