package com.cqut.atao.farm.pay.domain.clearsystem.common;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Constants.java
 * @Description 清分系统常量
 * @createTime 2023年03月02日 23:23:00
 */
public class Constants {


    public enum ClearingHandler{
        // 清分处理枚举
        ORDER(0,"订单清分处理");
        private Integer code;
        private String info;

        ClearingHandler(Integer code) {
            this.code = code;
        }

        ClearingHandler(Integer code, String info) {
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
