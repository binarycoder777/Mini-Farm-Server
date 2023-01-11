package com.cqut.atao.farm.springboot.starter.base.init;

import org.springframework.context.ApplicationEvent;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ApplicationInitializingEvent.java
 * @Description 应用初始化事件
 * @createTime 2023年01月11日 22:08:00
 */
public class ApplicationInitializingEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ApplicationInitializingEvent(Object source) {
        super(source);
    }
}
