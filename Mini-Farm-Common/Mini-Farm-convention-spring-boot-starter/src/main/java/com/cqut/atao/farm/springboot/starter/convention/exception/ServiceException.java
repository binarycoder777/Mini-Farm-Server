package com.cqut.atao.farm.springboot.starter.convention.exception;

import com.cqut.atao.farm.springboot.starter.convention.errorcode.BaseErrorCode;
import com.cqut.atao.farm.springboot.starter.convention.errorcode.IErrorCode;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ServiceException.java
 * @Description 服务端异常
 * @createTime 2023年01月10日 21:51:00
 */
public class ServiceException extends AbstractException {

    public ServiceException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }

    public ServiceException(IErrorCode errorCode) {
        this(null, errorCode);
    }

    public ServiceException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ServiceException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}

