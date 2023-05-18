package com.cqut.atao.farm.order.application.statistics;

import com.cqut.atao.farm.order.domain.model.res.OrderSalesVolume;
import com.cqut.atao.farm.order.domain.model.res.PendingTransactions;
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

    public PendingTransactions pendingTransactions() {
        return orderRepository.pendingTransactions();
    }

    public List<OrderSalesVolume> today() {
        List<OrderSalesVolume> list = Lists.newArrayList();
        // 当天
        Date one = currentDay();
        OrderSalesVolume orderSalesVolume = orderRepository.sales(one,new Date());
        list.add(orderSalesVolume);
        // 昨天
        Date tow = lastDay();
        orderSalesVolume = orderRepository.sales(tow,one);
        list.add(orderSalesVolume);
        return list;
    }

    public Date currentDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long todayZero = calendar.getTimeInMillis();
        return new Date(todayZero);
    }

    public Date lastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -1);
        long todayZero = calendar.getTimeInMillis();
        return new Date(todayZero);
    }

}
