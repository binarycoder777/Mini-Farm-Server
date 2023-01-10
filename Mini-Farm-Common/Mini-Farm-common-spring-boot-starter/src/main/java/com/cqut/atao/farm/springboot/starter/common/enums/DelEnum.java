package com.cqut.atao.farm.springboot.starter.common.enums;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DelEnum.java
 * @Description 删除标记枚举
 * @createTime 2023年01月10日 18:21:00
 */
public enum DelEnum {
    /**
     * 正常状态
     */
    NORMAL(0),

    /**
     * 删除状态
     */
    DELETE(1);

    private final Integer statusCode;

    DelEnum(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer code() {
        return this.statusCode;
    }

    public String strCode() {
        return String.valueOf(this.statusCode);
    }

    @Override
    public String toString() {
        return strCode();
    }
}

