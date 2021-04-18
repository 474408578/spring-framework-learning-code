package com.xschen.spring.aop.g_weawer.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.xschen.spring.aop.g_weawer.service.UserService.*(..))")
    public void beforePrint() {
        System.out.println("LogAspect 前置通知 ......");
    }
}
