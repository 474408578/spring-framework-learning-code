package com.xschen.spring.postprocessor.h_factoryprocessor;

import com.xschen.spring.postprocessor.h_factoryprocessor.bean.Red;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author xschen
 * @see BeanFactoryPostProcessor BeanDefinition的后置处理器, 与BeanPostProcessor没有任何关联，BeanPostProcessor 是影响bean实例的
 */


public class FactoryProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.postprocessor.h_factoryprocessor");
        Red red = ctx.getBean(Red.class);
        System.out.println(red);
    }
}
