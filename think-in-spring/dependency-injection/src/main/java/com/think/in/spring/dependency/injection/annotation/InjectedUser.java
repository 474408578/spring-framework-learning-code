package com.think.in.spring.dependency.injection.annotation;

import java.lang.annotation.*;

/**
 * 自定义依赖注入注解
 * @author xschen
 */


@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectedUser {
}
