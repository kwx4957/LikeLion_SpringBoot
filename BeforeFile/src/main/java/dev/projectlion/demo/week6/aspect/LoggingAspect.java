package dev.projectlion.demo.week6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect{
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Around(value = "@annotation(dev.projectlion.demo.week6.aspect.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long statTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long execTime = System.currentTimeMillis() - statTime ;
        logger.trace("method executer in {}", execTime);
        long endTime = System.currentTimeMillis() - statTime;

        return proceed;
    }

    @Before(value = "@annotation(dev.projectlion.demo.week6.aspect.LogArgument)")
    public void logParameter(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.trace("method description [{}]",  methodSignature.getMethod());
        logger.trace("method name: [{}]", methodSignature.getName());
        logger.trace("declare class: [{}]", methodSignature.getDeclaringType());

        Object[] arguments = joinPoint.getArgs();
        if (arguments.length == 0){
            logger.trace("no arguments");
        }
        for (Object argument:arguments){
            logger.trace("argument: [{}]", arguments);
        }

    }

    @AfterReturning(value = "@annotation(dev.projectlion.demo.week6.aspect.LogReturn)", returning = "returnValue")
    public void logResults(JoinPoint joinPoint, Object returnValue){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.trace("method [{}]",  methodSignature.getName());
        logger.trace("reutnr type [{}]", methodSignature.getReturnType());

        logger.trace("return value [{}]", returnValue);
    }
}
