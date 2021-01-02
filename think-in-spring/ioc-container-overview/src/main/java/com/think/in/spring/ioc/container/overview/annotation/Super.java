package com.think.in.spring.ioc.container.overview.annotation;

import java.lang.annotation.*;

/**
 * 超级
 * @author xschen
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Super {
}
