package com.cqut.atao.farm.springboot.starter.convention.exception;

import com.cqut.atao.farm.springboot.starter.convention.errorcode.BaseErrorCode;
import com.cqut.atao.farm.springboot.starter.convention.errorcode.IErrorCode;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ClientException.java
 * @Description 客户端异常
 * @createTime 2023年01月10日 21:50:00
 */
public class ClientException extends AbstractException {

    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}

