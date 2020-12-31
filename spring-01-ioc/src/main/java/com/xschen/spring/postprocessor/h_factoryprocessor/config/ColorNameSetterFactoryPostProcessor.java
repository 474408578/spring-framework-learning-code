package com.xschen.spring.postprocessor.h_factoryprocessor.config;

import com.xschen.spring.postprocessor.h_factoryprocessor.bean.Color;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

/**
 * @author xschen
 */

@Component
public class ColorNameSetterFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(beanName -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (StringUtils.hasText(beanDefinition.getBeanClassName())) {
                try {
                    if (Class.forName(beanDefinition.getBeanClassName()).getSuperclass().equals(Color.class)) {
                        beanDefinition.getPropertyValues().add("name", beanName);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
