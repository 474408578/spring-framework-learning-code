package com.xschen.spring.aop.b_aspectj.component;

import java.lang.annotation.*;

/**
 * 除了 execution 之外， 还有一种切入表达式也比较常用，@annotation
 * @author xschen
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
}
