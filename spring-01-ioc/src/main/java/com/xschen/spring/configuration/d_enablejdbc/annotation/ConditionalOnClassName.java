package com.xschen.spring.configuration.d_enablejdbc.annotation;

import com.xschen.spring.configuration.d_enablejdbc.components.OnClassNameConditional;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 组件是否需要被注册
 * @author xschen
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnClassNameConditional.class)
public @interface ConditionalOnClassName {
    String value();
}
