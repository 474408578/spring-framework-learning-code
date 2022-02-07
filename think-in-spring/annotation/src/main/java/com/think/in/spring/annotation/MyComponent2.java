package com.think.in.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * {@link MyComponent} “派生性” 注解
 * @author xschen
 * @date 2022/2/7 11:12
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponent
public @interface MyComponent2 { // @MyComponent2 <- @MyComponent <- @Component
}
