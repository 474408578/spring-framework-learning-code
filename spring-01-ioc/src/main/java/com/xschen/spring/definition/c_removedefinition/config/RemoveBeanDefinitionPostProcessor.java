package com.xschen.spring.definition.c_removedefinition.config;

import com.xschen.spring.definition.c_removedefinition.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 *
 * 编写剔除BeanDefinition的后置处理器
 * @see BeanFactoryPostProcessor
 */

@Component
public class RemoveBeanDefinitionPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // ConfigurableListableBeanFactory唯一实现是DefaultListableBeanFactory
        // DefaultListableBeanFactory实现了BeanDefinitionRegistry接口，
        // 可以将beanFactory强转为BeanDefinitionRegistry。
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;

        // 获取IOC容器中的所有BeanDefinition
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            // 判断BeanDefinition对应的Bean是否为Person类型
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);

            if (Person.class.getName().equals(beanDefinition.getBeanClassName())) {
                // 判断Person的性别是否为male
                TypedStringValue sex = (TypedStringValue) beanDefinition.getPropertyValues().get("sex");

                if ("male".equals(sex.getValue())) {
                    registry.removeBeanDefinition(beanDefinitionName);
                }
            }

        }

    }
}
