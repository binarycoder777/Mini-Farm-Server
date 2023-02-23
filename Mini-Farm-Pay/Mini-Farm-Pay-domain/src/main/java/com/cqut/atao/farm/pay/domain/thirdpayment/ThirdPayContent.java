package com.cqut.atao.farm.pay.domain.thirdpayment;

import com.cqut.atao.farm.pay.domain.thirdpayment.strategy.VxPayStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ThirdPayContent.java
 * @Description 三方支付上下文
 * @createTime 2023年02月23日 15:13:00
 */
@Component
public class ThirdPayContent {

    @Resource
    private VxPayStrategy vxPayStrategy;

    private Map<Integer,ThirdPay> thirdPayGroup = new ConcurrentHashMap<Integer, ThirdPay>();

    @PostConstruct
    public void ThirdPayContent(){
        thirdPayGroup.put(Constants.PayType.VX.getCode(),vxPayStrategy);
    }

    public ThirdPay getThirdPay(Integer payCode){
        return thirdPayGroup.get(payCode);
    }

}
