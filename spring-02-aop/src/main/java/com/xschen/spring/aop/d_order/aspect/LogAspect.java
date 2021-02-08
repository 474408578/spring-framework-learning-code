package com.xschen.spring.aop.d_order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * {@link @Order} 注解演示
 * @author xschen
 */


@Component
@Aspect
//@Order(Ordered.HIGHEST_PRECEDENCE - 3)
@Order(0)
public class LogAspect {

    @Before("execution(* com.xschen.spring.aop.d_order.service.UserService.*(..))")
    public void printLog() {
        System.out.println("LogAspect 打印日志 ......");
    }
}
