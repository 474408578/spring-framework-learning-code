package com.xschen.spring.postprocessor.i_registryprocessor.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 *
 * 注册animal的BeanDefinition的后置处理器
 */

@Component
public class AnimalProcessorRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 采用编程式注入AnimalNameSetterBeanFactoryPostProcessor
        registry.registerBeanDefinition("animalNameSetterBeanFactoryPostProcessor",
                new RootBeanDefinition(AnimalNameSetterBeanFactoryPostProcessor.class));
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
