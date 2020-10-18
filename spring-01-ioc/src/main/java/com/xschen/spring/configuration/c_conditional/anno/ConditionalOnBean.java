package com.xschen.spring.configuration.c_conditional.anno;

import com.xschen.spring.configuration.c_conditional.condition.OnBeanCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author xschen
 * 存在指定的bean时匹配
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnBeanCondition.class)
public @interface ConditionalOnBean {
    // 定义字段beanName数组。 使用全限定类名
    String[] beanNames() default {};

    // 不使用全限定类名，直接使用类字节码
    Class<?>[] value() default {};
}
