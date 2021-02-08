package com.xschen.spring.transation.aspect;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transactional {

}
