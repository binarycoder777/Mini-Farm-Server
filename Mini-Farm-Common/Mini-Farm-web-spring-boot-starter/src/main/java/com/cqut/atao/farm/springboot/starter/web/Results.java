package com.cqut.atao.farm.springboot.starter.web;

import com.cqut.atao.farm.springboot.starter.convention.errorcode.BaseErrorCode;
import com.cqut.atao.farm.springboot.starter.convention.exception.AbstractException;
import com.cqut.atao.farm.springboot.starter.convention.result.Result;

import java.util.Optional;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Results.java
 * @Description 全局返回对象
 * @createTime 2023年01月11日 14:36:00
 */
public class Results {
    /**
     * 构造成功响应
     *
     * @return
     */
    public static Result<Void> success() {
        return new Result<Void>().setCode(Result.SUCCESS_CODE);
    }

    /**
     * 构造带返回数据的成功响应
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>().setCode(Result.SUCCESS_CODE).setData(data);
    }

    /**
     * 构建服务端失败响应
     *
     * @return
     */
    protected static Result<Void> failure() {
        return new Result<Void>().setCode(BaseErrorCode.SERVICE_ERROR.code()).setMessage(BaseErrorCode.SERVICE_ERROR.message());
    }

    /**
     * 通过 {@link AbstractException} 构建失败响应
     *
     * @param abstractException
     * @return
     */
    protected static Result<Void> failure(AbstractException abstractException) {
        String errorCode = Optional.ofNullable(abstractException.getErrorCode()).orElse(BaseErrorCode.SERVICE_ERROR.code());
        String errorMessage = Optional.ofNullable(abstractException.getErrorMessage()).orElse(BaseErrorCode.SERVICE_ERROR.message());
        return new Result<Void>().setCode(errorCode).setMessage(errorMessage);
    }

    /**
     * 通过 errorCode、errorMessage 构建失败响应
     *
     * @param errorCode
     * @param errorMessage
     * @return
     */
    protected static Result<Void> failure(String errorCode, String errorMessage) {
        return new Result<Void>().setCode(errorCode).setMessage(errorMessage);
    }
}
