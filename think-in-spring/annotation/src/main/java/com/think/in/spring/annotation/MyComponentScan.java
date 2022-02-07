package com.think.in.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 自定义 {@link ComponentScan }
 * @author xschen
 * @date 2022/2/7 11:29
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan
public @interface MyComponentScan {

    // “多态”， 子注解提供新的属性方法引用 “父注解”中的属性方法
    @AliasFor(annotation = ComponentScan.class, attribute = "value")
    String[] scanBasePackages() default {"#"};
}
