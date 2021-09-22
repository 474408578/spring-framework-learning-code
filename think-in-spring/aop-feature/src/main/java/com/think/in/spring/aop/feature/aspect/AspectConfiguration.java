package com.think.in.spring.aop.feature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Random;

/**
 * Aspect 配置类
 * @author xschen
 * @date 2021/9/20 12:47
 */


@Aspect
@Order
public class AspectConfiguration {

    // 匹配 Joint Point
    @Pointcut("execution(public * *(..)))")
    private void anyPublicMethod(){
    }

    @Around("anyPublicMethod()")
    public Object aroundAnyPublicMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around any public method.");
        return joinPoint.proceed();
    }

    @Before("anyPublicMethod()")          // Join Point 拦截动作
    public void beforeAnyPublicMethod() throws Throwable {
        System.out.println("@Before any public method.");
    }

    @AfterReturning("anyPublicMethod()")
    public void afterReturningAnyPublicMethod() {
        System.out.println("@AfterReturning any public method.");
    }

    @After("anyPublicMethod()")
    public void afterFinalizeAnyPublicMethod() {
        System.out.println("@After any public method.");
    }

    @AfterThrowing("anyPublicMethod()")
    public void afterThrowingAnyPublicMethod() {
        System.out.println("@AfterThrowing any public method");
    }

}
