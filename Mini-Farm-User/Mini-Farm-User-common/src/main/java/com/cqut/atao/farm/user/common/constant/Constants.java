package com.cqut.atao.farm.user.common.constant;

import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Constants.java
 * @Description 用户服务常量
 * @createTime 2023年01月13日 16:54:00
 */
public class Constants {

    public enum LoginStrategy{

        /**
         * 登录策略
         */
        VX(0,"微信登录");

        private Integer code;
        private String info;

        LoginStrategy(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


}
