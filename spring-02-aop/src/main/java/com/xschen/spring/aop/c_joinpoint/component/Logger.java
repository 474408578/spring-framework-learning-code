package com.xschen.spring.aop.c_joinpoint.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 切面类
 * @author xschen
 */

@Aspect
@Component
public class Logger {

    @Before("execution(public * com.xschen.spring.aop.c_joinpoint.service.FinanceService.*(..))")
    public void beforePrint(JoinPoint joinPoint) {
        // 1. joinPoint.getTarget & joinPoint.getThis
        // joinPoint.getTarget 获取目标对象
        // joinPoint.getThis 获取代理对象
//        System.out.println(joinPoint.getTarget());
//        System.out.println(joinPoint.getThis().toString());
        // 重写了toString方法，所以为true
//        System.out.println(joinPoint.getThis().toString().equals(joinPoint.getTarget().toString()));

        // 2. joinPoint.getArgs 获取被拦截方法的参数列表
//        System.out.println(joinPoint.getArgs());

        // 3. joinPoint.getSignature 获取方法签名
//        System.out.println(joinPoint.getSignature());
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        System.out.println(method.getName());


        System.out.println("被拦截的类：" + joinPoint.getTarget().getClass().getName());
        System.out.println("被拦截的方法：" + ((MethodSignature)joinPoint.getSignature()).getMethod().getName());
        System.out.println("被拦截的方法参数：" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Logger beforePrint run ......");
    }

//    @After("execution(* com.xschen.spring.aop.c_joinpoint.service.*.*(String))")
    // 除了 execution 之外， 还有一种切入表达式也比较常用，@annotation
    @After("@annotation(com.xschen.spring.aop.c_joinpoint.component.Log)")
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }

    @AfterReturning(value = "execution(* com..FinanceService.subtractMoney(double))", returning = "retVal")
    public void afterReturningPrint(Object retVal) {
        System.out.println("Logger afterReturningPrint run ......");
        System.out.println("返回的数据：" + retVal);
    }

    @AfterThrowing(value = "defaultPointcut()", throwing = "e")
    public void afterThrowingPrint(Exception e) {
        System.out.println("Logger afterThrowingPrint run ......");
        System.out.println("抛出的异常：" + e.getMessage());
    }

    @Around("execution(public * com.xschen.spring.aop.c_joinpoint.service.FinanceService.addMoney(..))")
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
    @Pointcut("execution(* com.xschen.spring.aop.c_joinpoint.service.*.*(String))")
    public void defaultPointcut() {

    }
}
