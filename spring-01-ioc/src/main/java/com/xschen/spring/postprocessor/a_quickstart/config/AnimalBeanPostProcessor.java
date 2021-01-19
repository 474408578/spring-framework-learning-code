package com.xschen.spring.postprocessor.a_quickstart.config;

import com.xschen.spring.postprocessor.a_quickstart.bean.Cat;
import com.xschen.spring.postprocessor.a_quickstart.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * {@link BeanPostProcessor }示例
 * @author xschen
 *
 * @see AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization(Object, String)
 * @see AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization(Object, String)
 */

@Component
public class AnimalBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("拦截到Bean的初始化之前: " + bean.getClass().getName());
        // 当bean属于Cat时，返回其他类型的对象
        if (bean instanceof Cat) {
            return new Dog();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("拦截到Bean的初始化之后: " + bean.getClass().getName());
        return bean;
    }
}
