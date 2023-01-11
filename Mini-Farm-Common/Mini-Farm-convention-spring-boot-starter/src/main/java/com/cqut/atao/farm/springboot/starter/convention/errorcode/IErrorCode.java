package com.cqut.atao.farm.springboot.starter.convention.errorcode;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IErrorCode.java
 * @Description 平台错误码
 * @createTime 2023年01月10日 21:43:00
 */
public interface IErrorCode {

    /**
     * 错误码
     *
     * @return
     */
    String code();

    /**
     * 错误信息
     *
     * @return
     */
    String message();

}
