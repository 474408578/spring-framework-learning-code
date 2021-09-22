package com.think.in.spring.aop.feature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

/**
 * Aspect 配置类 2
 * @author xschen
 * @date 2021/9/20 12:47
 */


@Aspect
public class AspectConfiguration2 implements Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

    @Before("execution(public * *(..)))")
    public void beforeAnyPublicMethod() {
        System.out.println("@Before any public method.(2)");
    }

}
