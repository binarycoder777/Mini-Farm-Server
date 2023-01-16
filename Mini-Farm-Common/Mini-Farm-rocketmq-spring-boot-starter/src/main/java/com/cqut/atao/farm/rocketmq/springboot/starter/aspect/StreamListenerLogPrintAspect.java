package com.cqut.atao.farm.rocketmq.springboot.starter.aspect;

import com.alibaba.fastjson2.JSON;
import com.cqut.atao.farm.rocketmq.springboot.starter.core.MessageWrapper;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName StreamListenerLogPrintAspect.java
 * @Description 日志环绕打印
 * @createTime 2023年01月16日 10:39:00
 */
@Aspect
public final class StreamListenerLogPrintAspect {

    @SneakyThrows
    @Around("@within(org.springframework.cloud.stream.annotation.StreamListener) || @annotation(org.springframework.cloud.stream.annotation.StreamListener)")
    public Object streamListenerLogPrint(ProceedingJoinPoint joinPoint) {
        Object result;
        boolean executeResult = true;
        long startTime = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Logger log = LoggerFactory.getLogger(methodSignature.getDeclaringType());
        try {
            result = joinPoint.proceed();
        } catch (Throwable ex) {
            executeResult = false;
            throw ex;
        } finally {
            Object[] args = joinPoint.getArgs();
            if (args != null && args.length > 0) {
                Optional<MessageWrapper> messageWrapperOptional = Arrays.stream(args)
                        .filter(each -> each instanceof MessageWrapper)
                        .map(each -> (MessageWrapper) each)
                        .findFirst();
                if (messageWrapperOptional.isPresent()) {
                    MessageWrapper messageWrapper = messageWrapperOptional.get();
                    log.info("Execute result: {}, Keys: {}, Dispatch time: {} ms, Execute time: {} ms, Message: {}",
                            executeResult,
                            messageWrapper.getKeys(),
                            System.currentTimeMillis() - messageWrapper.getTimestamp(),
                            System.currentTimeMillis() - startTime,
                            JSON.toJSONString(messageWrapper.getMessage()));
                }
            }
        }
        return result;
    }
}

