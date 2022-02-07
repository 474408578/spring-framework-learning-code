package com.think.in.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义 {@link Component} “派生性” 注解
 * @author xschen
 * @date 2022/2/7 11:09
 * @see Component
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component // 元注解，实现 @Component "派生性"
public @interface MyComponent {
}
