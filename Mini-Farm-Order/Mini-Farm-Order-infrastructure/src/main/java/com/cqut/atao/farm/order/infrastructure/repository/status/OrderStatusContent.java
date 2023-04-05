package com.cqut.atao.farm.order.infrastructure.repository.status;

import com.cqut.atao.farm.order.domain.common.Constants;
import com.cqut.atao.farm.order.infrastructure.repository.status.strategy.AfterSalesOrder;
import com.cqut.atao.farm.order.infrastructure.repository.status.strategy.AllOrder;
import com.cqut.atao.farm.order.infrastructure.repository.status.strategy.NormalOrder;
import com.cqut.atao.farm.order.infrastructure.repository.status.strategy.UnpiadOrder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderStatusContent.java
 * @Description 订单状态上下文
 * @createTime 2023年04月04日 09:26:00
 */
@Component
public class OrderStatusContent {

    @Resource
    private AfterSalesOrder afterSalesOrder;

    @Resource
    private AllOrder allOrder;

    @Resource
    private NormalOrder normalOrder;

    @Resource
    private UnpiadOrder unpiadOrder;

    public final Map<Constants.FrontOrderState,PageQueryOrderInfo> maps = new ConcurrentHashMap<>();

    @PostConstruct
    private void Init() {
        maps.put(Constants.FrontOrderState.AFTER_SALES,afterSalesOrder);
        maps.put(Constants.FrontOrderState.ALL,allOrder);
        maps.put(Constants.FrontOrderState.NORMAL,normalOrder);
        maps.put(Constants.FrontOrderState.UN_PAID,unpiadOrder);
    }

}
