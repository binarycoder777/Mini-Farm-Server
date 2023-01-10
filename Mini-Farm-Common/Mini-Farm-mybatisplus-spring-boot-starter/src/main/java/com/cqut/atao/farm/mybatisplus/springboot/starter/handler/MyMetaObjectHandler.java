package com.cqut.atao.farm.mybatisplus.springboot.starter.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.cqut.atao.farm.springboot.starter.common.enums.DelEnum;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MyMetaObjectHandler.java
 * @Description 元数据处理器
 * @createTime 2023年01月10日 18:17:00
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 数据新增时填充
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "delFlag", Integer.class, DelEnum.NORMAL.code());
    }

    /**
     * 数据修改时填充
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
    }
}
