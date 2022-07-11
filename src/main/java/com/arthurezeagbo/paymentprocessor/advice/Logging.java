package com.arthurezeagbo.paymentprocessor.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logging {

    Logger logger = LoggerFactory.getLogger(String.class);

    @Pointcut("execution(* com.arthurezeagbo.paymentprocessor.*.*.*(..))")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object instrumentation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String className = proceedingJoinPoint.getTarget().toString();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String argument = objectMapper.writeValueAsString(proceedingJoinPoint.getArgs());
        Object pjp = proceedingJoinPoint.proceed();
        logger.info(String.format("Application class ==>> %s\n executing method ==>> %s\n request payload ==>> %s",
                className, methodName, argument));
        return pjp;
    }
}
