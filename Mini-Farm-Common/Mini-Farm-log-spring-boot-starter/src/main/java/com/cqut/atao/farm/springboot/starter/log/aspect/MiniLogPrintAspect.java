package com.cqut.atao.farm.springboot.starter.log.aspect;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;
import com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog;
import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import static com.alibaba.fastjson2.JSONWriter.Feature.MapSortField;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MiniLogPrintAspect.java
 * @Description {@link MiniLog} 日志打印 AOP 切面
 * @createTime 2023年01月10日 17:15:00
 */
@Aspect
public class MiniLogPrintAspect {

    /**
     * 打印类或方法上的 {@link MiniLog}
     */
    @Around("@within(com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog) || @annotation(com.cqut.atao.farm.springboot.starter.log.annotation.MiniLog)")
    public Object printMiniLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Logger log = LoggerFactory.getLogger(methodSignature.getDeclaringType());
        long startTime = System.currentTimeMillis();
        String beginTime = DateUtil.now();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } finally {
            Method targetMethod = joinPoint.getTarget().getClass().getDeclaredMethod(methodSignature.getName(), methodSignature.getMethod().getParameterTypes());
            MiniLog logAnnotation = Optional.ofNullable(targetMethod.getAnnotation(MiniLog.class)).orElse(joinPoint.getTarget().getClass().getAnnotation(MiniLog.class));
            if (logAnnotation != null) {
                MiniLogPrint logPrint = new MiniLogPrint();
                logPrint.setBeginTime(beginTime);
                if (logAnnotation.input()) {
                    logPrint.setInputParams(buildInput(joinPoint));
                }
                if (logAnnotation.output()) {
                    logPrint.setOutputParams(result);
                }
                String methodType = "", requestURI = "";
                try {
                    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                    methodType = servletRequestAttributes.getRequest().getMethod();
                    requestURI = servletRequestAttributes.getRequest().getRequestURI();
                } catch (Exception ignored) {
                }
                log.info("[{}] {}, executeTime: {}ms, info: {}", methodType, requestURI, System.currentTimeMillis() - startTime, JSON.toJSONString(logPrint, MapSortField));
            }
        }
        return result;
    }

    private Object[] buildInput(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object[] printArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if ((args[i] instanceof HttpServletRequest) || args[i] instanceof HttpServletResponse) {
                continue;
            }
            if (args[i] instanceof byte[]) {
                printArgs[i] = "byte array";
            } else if (args[i] instanceof MultipartFile) {
                printArgs[i] = "file";
            } else {
                printArgs[i] = args[i];
            }
        }
        return printArgs;
    }

    @Data
    private class MiniLogPrint {

        @JSONField
        private String beginTime;

        @JSONField(ordinal = 1)
        private Object[] inputParams;

        @JSONField(ordinal = 2)
        private Object outputParams;
    }

}
