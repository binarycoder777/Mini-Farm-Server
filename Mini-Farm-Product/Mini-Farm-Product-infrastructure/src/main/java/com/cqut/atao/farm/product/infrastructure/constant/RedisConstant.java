package com.cqut.atao.farm.product.infrastructure.constant;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RedisConstant.java
 * @Description redis枚举key
 * @createTime 2023年04月14日 15:32:00
 */
public enum  RedisConstant {

    /**
     * 用户足迹key
     */
    USER_FOOT("USER_FOOT:");

    private String info;

    RedisConstant(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
