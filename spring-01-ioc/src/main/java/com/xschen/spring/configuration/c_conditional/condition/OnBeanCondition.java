package com.xschen.spring.configuration.c_conditional.condition;

import com.xschen.spring.configuration.c_conditional.anno.ConditionalOnBean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author xschen
 *
 * 传入的Condition类型为自己声明的OnBeanCondition
 */


public class OnBeanCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(
                ConditionalOnBean.class.getName());

        // 匹配类型
        Class<?>[] classes = (Class<?>[]) attributes.get("value");
        for (Class<?> clazz : classes) {
            if (!context.getBeanFactory().containsBeanDefinition(clazz.getName())) {
                return false;
            }
        }

        // 匹配BeanName, 逐个校验IOC容器中是否包含Bean名称(依赖的bean名称)
//        String[] beanNames = (String[]) attributes.get("beanNames");
//        for (String beanName : beanNames) {
//            if (!context.getBeanFactory().containsBeanDefinition(beanName)) {
//                return false;
//            }
//        }

        return true;
    }
}
