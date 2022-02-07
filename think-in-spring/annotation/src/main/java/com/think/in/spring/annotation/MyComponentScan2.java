package com.think.in.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 自定义 {@link ComponentScan}
 * @author xschen
 * @date 2022/2/7 11:34
 * @see ComponentScan
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponentScan
public @interface MyComponentScan2 {
    // @MyComponentScan2.basePackages <- @MyComponentScan.scanBasePackages <- @ComponentScan.value
    @AliasFor(annotation = MyComponentScan.class, attribute = "scanBasePackages")
    String[] basePackages() default {};

    /**
     * 与元注解 @MyComponentScan 同名属性
     */
    String[] scanBasePackages() default {};

    /**
     * packages 覆盖了 MyComponentScan2.scanBasePackages 覆盖了 MyComponentScan.scanBasePackages
     */
    @AliasFor("scanBasePackages")
    String[] packages() default {};
}
