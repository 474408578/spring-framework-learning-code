package com.xschen.spring.postprocessor.c_executetime.config;

import com.xschen.spring.postprocessor.c_executetime.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class BeanPostProcessorExecuteTime implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Dog) {
            System.out.println("postProcessBeforeInitialization ……");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Dog) {
            System.out.println("postProcessAfterInitialization ……");
        }
        return bean;
    }
}
