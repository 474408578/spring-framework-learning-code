package com.xschen.spring.configuration.c_conditional.condition;

import com.xschen.spring.configuration.c_conditional.component.Boss;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xschen
 * todo: 用于判断IOC中是否存在Boss对象
 */


public class ExistBossCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 这个地方用 BeanDefinition 做判断而不是 Bean ，
        // 考虑的是当条件匹配时，可能 Boss 还没被创建，导致条件匹配出现偏差。
        return conditionContext.getBeanFactory().containsBeanDefinition(Boss.class.getName());
    }
}
