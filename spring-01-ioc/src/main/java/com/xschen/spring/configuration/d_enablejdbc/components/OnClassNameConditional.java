package com.xschen.spring.configuration.d_enablejdbc.components;

import com.xschen.spring.configuration.d_enablejdbc.annotation.ConditionalOnClassName;
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
            // 判断classpath下是不是有指定的数据库连接驱动，使用类加载器加载，如果成功，则有，
            // 如果抛出ClassNotFoundException，就代表没有
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}

