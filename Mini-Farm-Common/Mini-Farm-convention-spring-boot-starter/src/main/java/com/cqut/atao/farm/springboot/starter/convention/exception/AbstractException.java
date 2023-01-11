package com.cqut.atao.farm.springboot.starter.convention.exception;

import com.cqut.atao.farm.springboot.starter.convention.errorcode.IErrorCode;
import com.google.common.base.Strings;
import lombok.Getter;

import java.util.Optional;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AbstractException.java
 * @Description 抽象异常
 * @createTime 2023年01月10日 21:42:00
 */
@Getter
public abstract class AbstractException extends RuntimeException {

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(Strings.emptyToNull(message)).orElse(errorCode.message());
    }
}
