package com.think.in.spring.aop.feature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Random;

/**
 * Aspect Xml 配置类
 * @author xschen
 * @date 2021/9/20 18:53
 */

public class AspectXmlConfiguration {

    public void beforeAnyPublicMethod() {

        System.out.println("@Before any public method.");
    }

    public Object aroundAnyPublicMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around any public method: " + joinPoint.getSignature());
        return joinPoint.proceed();
    }

    public void afterReturningAnyPublicMethod() {
        System.out.println("@AfterReturning any public method.");
    }

    public void afterFinalizeAnyPublicMethod() {
        System.out.println("@After any public method.");
    }

    public void afterThrowingAnyPublicMethod() {
        System.out.println("@AfterThrowing any public method");
    }
}
