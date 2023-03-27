package com.cqut.atao.farm.pay.domain.clearsystem;

import com.cqut.atao.farm.pay.domain.clearsystem.common.Constants;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ClearingSystem.java
 * @Description 清分系统
 * @createTime 2023年03月02日 23:20:00
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ClearingSystem extends ClearingConfig{

    /**
     * 清分处理
     * @param clearingHandler 类型
     * @param data 数据
     */
    public void doClearing(Constants.ClearingHandler clearingHandler,Object data) {
       clearingHandlerMap.get(clearingHandler).clearing(data);
    }

}
