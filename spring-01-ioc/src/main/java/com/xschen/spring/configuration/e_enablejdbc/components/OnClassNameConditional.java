package com.xschen.spring.configuration.e_enablejdbc.components;

import com.xschen.spring.configuration.e_enablejdbc.annotation.ConditionalOnClassName;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xschen
 */


public class OnClassNameConditional implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取目标自定义注解ConditionalOnClassName上的value属性
        String className = (String) metadata
                .getAnnotationAttributes(ConditionalOnClassName.class.getName())
                .get("value");
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}

