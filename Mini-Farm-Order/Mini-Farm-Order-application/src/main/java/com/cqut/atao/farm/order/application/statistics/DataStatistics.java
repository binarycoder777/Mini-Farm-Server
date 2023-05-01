package com.cqut.atao.farm.order.application.statistics;

import com.cqut.atao.farm.order.domain.model.res.OrderSalesVolume;
import com.cqut.atao.farm.order.domain.repository.OrderRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DataStatistics.java
 * @Description 数据统计
 * @createTime 2023年05月01日 19:36:00
 */
@Service
public class DataStatistics {

    @Resource
    private OrderRepository orderRepository;

    public List<OrderSalesVolume> orderSalesVolumeStatistics(Date start,Date end){
        List<OrderSalesVolume> list = Lists.newArrayList();
        Date current = new Date(start.getTime());
        while (current.before(end)) {
            OrderSalesVolume orderSalesVolume = orderRepository.orderSalesVolumeStatistics(current);
            list.add(orderSalesVolume);
            // 当前时间+1天
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(current);
            calendar.add(Calendar.DATE, 1);
            current = calendar.getTime();
        }
        return list;
    }

}
