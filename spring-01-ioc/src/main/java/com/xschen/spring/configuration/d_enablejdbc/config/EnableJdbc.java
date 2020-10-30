package com.xschen.spring.configuration.d_enablejdbc.config;

import com.xschen.spring.configuration.d_enablejdbc.config.JdbcConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(JdbcConfiguration.class)
public @interface EnableJdbc {
}
