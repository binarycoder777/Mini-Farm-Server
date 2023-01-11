package com.cqut.atao.farm.springboot.starter.convention.exception;

import com.cqut.atao.farm.springboot.starter.convention.errorcode.IErrorCode;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemoteException.java
 * @Description 远程服务调用异常
 * @createTime 2023年01月10日 21:51:00
 */
public class RemoteException extends AbstractException {

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
