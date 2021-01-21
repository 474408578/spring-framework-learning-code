package com.xschen.spring.postprocessor.i_registryprocessor.config;

import com.xschen.spring.postprocessor.i_registryprocessor.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 *
 * 注册dog的后置处理器
 */

@Component
public class DogRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("DogRegistryPostProcessor postProcessBeanDefinitionRegistry run ......");
        if (!registry.containsBeanDefinition("dog")) {
            // 构造 dog BeanDefinition
            AbstractBeanDefinition dogDefinition = BeanDefinitionBuilder.genericBeanDefinition(Dog.class).getBeanDefinition();
            registry.registerBeanDefinition("dog", dogDefinition);
        }

    }

    // 注册BeanFactoryPostProcessor
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("DogRegisterPostProcessor postProcessBeanFactory run ......");
    }
}
