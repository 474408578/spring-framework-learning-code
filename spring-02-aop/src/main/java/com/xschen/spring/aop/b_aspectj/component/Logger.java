package com.xschen.spring.aop.b_aspectj.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * @author xschen
 */

@Aspect // 切面类
@Component
public class Logger {

    @Before("execution(public * com.xschen.spring.aop.b_aspectj.service.FinanceService.*(..))")  // pointcut
    public void beforePrint() {
        System.out.println("Logger beforePrint run ......");
    }

//    @After("execution(* com.xschen.spring.aop.b_aspectj.service.*.*(String))")
    // 除了 execution 之外， 还有一种切入表达式也比较常用，@annotation
    @After("@annotation(com.xschen.spring.aop.b_aspectj.component.Log)")
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }

    @AfterReturning("execution(* com.xschen.spring.aop.b_aspectj.service.*.*(String))")
    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......");
    }

    @After("defaultPointcut()")
    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......");
    }

    @Around("execution(public * com.xschen.spring.aop.b_aspectj.service.FinanceService.addMoney(..))")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logger aroundPrint before run ......");
        try {
            Object retlVal = joinPoint.proceed(); // 相当于动态代理中的 method.invoke(target, args)
            System.out.println("Logger aroundPoint afterReturning run ......");
            return retlVal;
        } catch (Throwable throwable) {
            System.out.println("Logger aroundPoint afterThrowing run ......");
            throw throwable;
        } finally {
            System.out.println("Logger aroundPrint after run ......");
        }
    }

    /**
     * 抽取通用的 AspectJ 注解
     */
    @Pointcut("execution(* com.xschen.spring.aop.b_aspectj.service.*.*(String))")
    public void defaultPointcut() {

    }
}
