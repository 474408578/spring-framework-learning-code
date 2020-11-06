package com.xschen.spring.lifecycle.e_source.config;

import com.xschen.spring.lifecycle.e_source.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author xschen
 */


public class LifecycleNameReadBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            Person person = (Person) bean;
            System.out.println("LifecycleNameReadPostProcessor ----->" + person.getName());
        }
        return bean;
    }
}
