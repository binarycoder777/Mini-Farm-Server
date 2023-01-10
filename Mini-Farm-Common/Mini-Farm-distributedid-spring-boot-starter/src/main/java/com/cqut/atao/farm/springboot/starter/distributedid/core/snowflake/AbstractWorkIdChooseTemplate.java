package com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake;


import cn.hutool.core.date.SystemClock;
import com.cqut.atao.farm.springboot.starter.distributedid.SnowflakeIdUtil;
import com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake.wrapper.WorkIdWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AbstractWorkIdChooseTemplate.java
 * @Description 雪花算法模板生成
 * @createTime 2023年01月10日 20:21:00
 */
@Slf4j
public abstract class AbstractWorkIdChooseTemplate {

    /**
     * 是否使用 {@link SystemClock} 获取当前时间戳
     */
    @Value("${congomall.distributed.id.snowflake.is-use-system-clock:false}")
    private boolean isUseSystemClock;

    /**
     * 根据自定义策略获取 WorkId 生成器
     *
     * @return
     */
    protected abstract WorkIdWrapper chooseWorkId();

    /**
     * 选择 WorkId 并初始化雪花
     */
    public void chooseAndInit() {
        WorkIdWrapper workIdWrapper = chooseWorkId();
        long workId = workIdWrapper.getWorkId();
        long dataCenterId = workIdWrapper.getDataCenterId();
        Snowflake snowflake = new Snowflake(workId, dataCenterId, isUseSystemClock);
        log.info("Snowflake type: {}, workId: {}, dataCenterId: {}", this.getClass().getSimpleName(), workId, dataCenterId);
        SnowflakeIdUtil.initSnowflake(snowflake);
    }
}
