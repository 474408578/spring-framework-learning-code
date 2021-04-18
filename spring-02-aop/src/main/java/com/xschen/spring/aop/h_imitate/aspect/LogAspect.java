package com.xschen.spring.aop.h_imitate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */


@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.xschen.spring.aop.h_imitate.service.UserService.*(..))")
    public void beforePrintLog() {
        System.out.println("LogAspect beforePrint ......");
    }
}
