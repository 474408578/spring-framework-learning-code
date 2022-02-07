package com.think.in.spring.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xschen
 * @date 2021/12/20 9:13
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(HelloWorldConfiguration.class) // 方式一：通过import 配置类
//@Import(HelloWorldImportSelector.class) // 方式二：通过import ImportSelector 实现
@Import(HelloWorldImportBeanDefinitionRegistrar.class) // 方式三： 通过import ImportBeanDefinitionRegistrar 实现
public @interface EnableHelloWorld {
}
