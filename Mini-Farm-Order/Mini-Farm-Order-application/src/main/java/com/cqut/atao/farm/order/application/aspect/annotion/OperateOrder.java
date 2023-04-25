package com.cqut.atao.farm.order.application.aspect.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OperateOrder.java
 * @Description 订单操作注解
 * @createTime 2023年04月25日 14:27:00
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateOrder {

    /**
     * 操作模版
     * @return
     */
    String operateModel() default "";


    /**
     * 记录操作
     * @return
     */
    boolean doRecord() default true;

}
