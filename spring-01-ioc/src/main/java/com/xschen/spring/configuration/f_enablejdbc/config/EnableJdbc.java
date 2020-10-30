package com.xschen.spring.configuration.f_enablejdbc.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(JdbcConfiguration.class)
public @interface EnableJdbc {
}
