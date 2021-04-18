package com.xschen.spring.aop.d_order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


/**
 * 在不显示声明order排序值时，默认的排序值时Integer.MAX_VALUE, 越小则表示越优先
 * @author xschen
 */

@Component
@Aspect
public class TransactionAspect implements Ordered {

    @Before("execution(* com.xschen.spring.aop.d_order.service..UserService.*(..))")
    public void beginTransaction() {
        System.out.println("TransactionAspect 开启事务 ......");
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}

