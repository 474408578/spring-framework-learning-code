package com.xschen.spring.postprocessor.h_factoryprocessor.config;

import com.xschen.spring.postprocessor.h_factoryprocessor.bean.Color;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

/**
 * @author xschen
 * @see BeanFactoryPostProcessor 处理目标：BeanDefinition; 执行时机：BeanDefinition 解析完毕，注册进 BeanFactory 的阶段（ bean 未实例化）
 * @see BeanPostProcessor 处理目标：bean 实例; 执行时机：bean 的初始化阶段前后（已创建出 bean 对象）
 */

@Component
public class ColorNameSetterFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(beanName -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (StringUtils.hasText(beanDefinition.getBeanClassName())) {
                // 利用Spring提供的ClassUtils来避免捕捉异常
                if (ClassUtils.resolveClassName(beanDefinition.getBeanClassName(), this.getClass().getClassLoader())
                        .getSuperclass().equals(Color.class)) { // 判断父类是否为Color
                    beanDefinition.getPropertyValues().addPropertyValue("name", beanName);
                }
            }
        });
    }
}
