package com.cqut.atao.farm.pay.domain.acquiresystem.check;

import com.cqut.atao.farm.pay.domain.acquiresystem.check.filter.OrderCheck;
import com.cqut.atao.farm.pay.domain.acquiresystem.check.filter.ProductCheck;
import com.cqut.atao.farm.pay.domain.acquiresystem.check.filter.UserCheck;
import com.cqut.atao.farm.pay.domain.thirdpayment.model.aggreate.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CheckHandler.java
 * @Description 核验处理类
 * @createTime 2023年02月23日 19:27:00
 */
@Component
public class CheckHandler{

    private AbstractCheck check;

    @Resource
    private UserCheck userCheck;
    @Resource
    private ProductCheck productCheck;
    @Resource
    private OrderCheck orderCheck;

    public boolean doCheck(Order order) {
        return check.doCheck(order);
    }

    @PostConstruct
    public void InitFilter() {
        check = userCheck.appendNext(productCheck.appendNext(orderCheck));
    }
}
