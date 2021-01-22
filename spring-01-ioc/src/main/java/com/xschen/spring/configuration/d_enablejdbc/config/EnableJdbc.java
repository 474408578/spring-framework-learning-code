package com.xschen.spring.configuration.d_enablejdbc.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 声明模块装配的注解，模块装配的核心原则：自定义注解 + @Import导入组件
 * @author xschen
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(JdbcConfiguration.class)
public @interface EnableJdbc {
}
