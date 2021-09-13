package com.xschen.spring.definition.b_registry.registar;

import com.xschen.spring.definition.b_registry.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * {@link BeanDefinitionBuilder } 示例
 * @author xschen
 * todo: 注入bean
 * @see DefaultListableBeanFactory#registerBeanDefinition(String, BeanDefinition) 往beanDefinitionMap加入元素
 * @see BeanDefinitionRegistry#registerBeanDefinition(String, BeanDefinition)
 * @see MutablePropertyValues
 */


public class PersonRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        beanDefinitionBuilder.addPropertyValue("name", "zhangsan");
        registry.registerBeanDefinition("person", beanDefinitionBuilder.getBeanDefinition());
    }
}
