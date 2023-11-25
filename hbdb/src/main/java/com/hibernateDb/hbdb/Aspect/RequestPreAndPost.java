package com.hibernateDb.hbdb.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class RequestPreAndPost {

    public static Logger log= Logger.getLogger(RequestPreAndPost.class.getName());

//
//    @Pointcut("execution(public * com.hibernateDb.hbdb.*.*(..))")
//    public void pointcutExpressionForController(){ }
//    @Around("pointcutExpressionForController")
//    public Object saveLog(ProceedingJoinPoint point) throws Throwable {
//        long begin=System.currentTimeMillis();
//        Object result=point.proceed();
//        long end=System.currentTimeMillis();
//        long duration=end-begin;
//        System.out.println("Duration : "+duration);
//        return result;
//
//    }



}
