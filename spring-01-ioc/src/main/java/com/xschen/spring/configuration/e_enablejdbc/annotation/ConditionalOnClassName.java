package com.xschen.spring.configuration.e_enablejdbc.annotation;

import com.xschen.spring.configuration.e_enablejdbc.components.OnClassNameConditional;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnClassNameConditional.class)
public @interface ConditionalOnClassName {
    String value();
}
