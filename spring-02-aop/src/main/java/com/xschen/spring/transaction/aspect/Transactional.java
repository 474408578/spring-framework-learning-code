package com.xschen.spring.transaction.aspect;

import java.lang.annotation.*;

/**
 * 切入点
 * @author xschen
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transactional {

}
