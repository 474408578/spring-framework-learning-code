package com.xschen.spring.aop.d_order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 同一个切面内的多个advice 执行顺序只能依靠方法名控制（字母表）
 * @author xschen
 */


@Component
@Aspect
public class AbcAspect {

    @Before("execution(* com.xschen.spring.aop.d_order.service.UserService.*(..))")
    public void abc() {
        System.out.println("abc abc abc");
    }

    @Before("execution(* com.xschen.spring.aop.d_order.service.UserService.*(..))")
//    @Order(Ordered.HIGHEST_PRECEDENCE) // 不生效
    public void def() {
        System.out.println("def def def");
    }
}
