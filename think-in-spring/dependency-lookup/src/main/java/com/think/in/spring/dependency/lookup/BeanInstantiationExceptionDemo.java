package com.think.in.spring.dependency.lookup;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link org.springframework.beans.BeanInstantiationException} 示例
 * @author xschen
 */


public class BeanInstantiationExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册BeanDefinition Bean Class 是一个CharSequence接口
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
        applicationContext.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());

        applicationContext.refresh();

        applicationContext.close();

    }
}
