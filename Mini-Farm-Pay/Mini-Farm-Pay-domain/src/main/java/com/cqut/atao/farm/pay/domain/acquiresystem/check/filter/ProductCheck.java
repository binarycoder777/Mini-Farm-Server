package com.cqut.atao.farm.pay.domain.acquiresystem.check.filter;

import com.cqut.atao.farm.pay.domain.acquiresystem.check.AbstractCheck;
import com.cqut.atao.farm.pay.domain.model.aggreate.Order;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserCheck.java
 * @Description 商品信息核验
 * @createTime 2023年02月23日 19:21:00
 */
@Slf4j
@Data
@Builder
@Component
public class ProductCheck extends AbstractCheck {


    @Override
    public boolean doCheck(Order order) {
        log.info("商品信息核验无误");
        if (this.next() == null) {
            return true;
        }
        return this.next().doCheck(order);
    }

}
