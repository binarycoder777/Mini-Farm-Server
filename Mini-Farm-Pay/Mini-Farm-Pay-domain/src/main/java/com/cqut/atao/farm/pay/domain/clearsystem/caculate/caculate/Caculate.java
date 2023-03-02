package com.cqut.atao.farm.pay.domain.clearsystem.caculate.caculate;

import com.cqut.atao.farm.pay.domain.model.res.ClearingRecordRes;
import com.cqut.atao.farm.pay.domain.remote.model.res.OrderInfoRes;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Caculate.java
 * @Description 计算服务接口
 * @createTime 2023年03月02日 22:13:00
 */
public interface Caculate {


    /**
     * 计算处理
     * @param model 模型
     * @param rule 规则
     * @param data 数据
     * @return 清分记录
     */
    List<ClearingRecordRes> process(Object model,Object rule,Object data);

}
