package com.think.in.spring.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 偶数 Profile 条件
 * @author xschen
 * @date 2022/2/7 14:03
 */

public class EvenProfileCondition  implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().acceptsProfiles(Profiles.of("even"));
    }
}
